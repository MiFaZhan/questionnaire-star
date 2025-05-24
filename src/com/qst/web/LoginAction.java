package com.qst.web;

import com.qst.pojo.User;
import com.qst.service.IQuestionnaireService;
import com.qst.service.QuestionnaireServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author qst
 *
 * 登录处理类
 *
 */
@WebServlet("/login")
public class LoginAction extends HttpServlet {
    private IQuestionnaireService questionaireService;
    public LoginAction() {
        questionaireService=new QuestionnaireServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取参
        String un=req.getParameter("uname");
        String up=req.getParameter("upass");
        //完成业务
        User user=questionaireService.verifyLogin(un, up);
        if(user!=null) { //登录成功
            req.getSession().setAttribute("user", user);//将用户信息保存在session中
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
        }else {
            req.setAttribute("msg", "用户名或者密码错误!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}

