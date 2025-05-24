package com.qst.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;

/**
 *
 * @author qst
 *
 * 实现自定义请求,用自定义替换替换原始的request
 *
 */
public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request=request;
    }
    @Override
    public String getParameter(String name) {//替换原来的getParameter()
        String oldValue=request.getParameter(name);
        List<String> words=(List<String>)request.getServletContext().getAttribute("words");
        for(String w:words) { //通过循环，依次判断所有敏感字是否存在
            if(oldValue.indexOf(w)!=-1) {//如存在
                oldValue=oldValue.replaceAll(w, "***");//进行替换
            }
        }
        return oldValue;
    }
}
