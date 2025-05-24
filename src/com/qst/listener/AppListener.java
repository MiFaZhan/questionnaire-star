package com.qst.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qst
 *
 * 应用程序监听器
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
    private static List<String> words;//敏感字集合
    static {
        words=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new InputStreamReader(
                AppListener.class.getClassLoader().getResourceAsStream("words.txt")
        ));){
            String word=br.readLine();//读取第一行
            while(word!=null) {
                words.add(word);//加入集合
                word=br.readLine();
            }}catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    //项目初始化调用,创建连接池，线程池
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context=sce.getServletContext();//获取servlet上下文
        context.setAttribute("words", words);//将敏感字集合加入应用程序作用域

    }
    //项目销毁时调用,释放资源
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("words");//从应用程序作用域移除敏感字集合
    }
}
