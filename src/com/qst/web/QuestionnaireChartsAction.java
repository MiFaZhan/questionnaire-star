package com.qst.web;

import com.qst.service.IQuestionnaireService;
import com.qst.service.QuestionnaireServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author qst
 *
 * 显示问卷数量统计数据
 *
 */
@WebServlet("/questionnaire/statistics")
public class QuestionnaireChartsAction extends HttpServlet {

    private IQuestionnaireService questionaireService;
    public QuestionnaireChartsAction() {
        questionaireService=new QuestionnaireServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> numList=questionaireService.queryNumByType();
        req.setAttribute("data", numList.toString());//将集合的字符串表示存入请求作用域，例如：[1, 2, 3]
        req.getRequestDispatcher("/questionnaire_charts.jsp").forward(req, resp);
    }
}
