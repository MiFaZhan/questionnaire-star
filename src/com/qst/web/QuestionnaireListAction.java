package com.qst.web;

import com.qst.pojo.Questionnaire;
import com.qst.service.IQuestionnaireService;
import com.qst.service.QuestionnaireServiceImpl;
import com.qst.util.ParseUtil;

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
 * 显示指定类型问卷列表
 *
 */
@WebServlet("/questionnaire/questionnairelist")
public class QuestionnaireListAction extends HttpServlet {

    private IQuestionnaireService questionaireService;

    public QuestionnaireListAction() {
        questionaireService = new QuestionnaireServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionaireTypeId= ParseUtil.parseToInteger(req.getParameter("questionnaireTypeId"));
        List<Questionnaire> questionnaireList = questionaireService.listAllQuestionnaire(questionaireTypeId);
        if (questionnaireList.size() > 0) {
            req.setAttribute("questionaireTypeId", questionaireTypeId);//问卷类型ID
            req.setAttribute("questionnaireList", questionnaireList);//问卷集合
        } else {
            req.setAttribute("msg", "当前没有数据存在");
        }
        req.getRequestDispatcher("/questionnaire_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
