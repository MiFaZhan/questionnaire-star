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

/**
 *
 * @author qst
 *
 * 问卷新增
 *
 */
@WebServlet("/questionnaire/save")
public class QuestionnaireSaveAction extends HttpServlet {
    private IQuestionnaireService questionaireService;

    public QuestionnaireSaveAction() {
        questionaireService = new QuestionnaireServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String questionnaireTitle = req.getParameter("questionnaireTitle");
        Integer questionnaireTypeId = ParseUtil.parseToInteger(req.getParameter("questionnaireTypeId"));
        // 组装数据
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setQuestionnaireTitle(questionnaireTitle);
        questionnaire.setQuestionnaireTypeId(questionnaireTypeId);
        // 完成业务
        int rows = questionaireService.addQuestionnaire(questionnaire);
        if (rows > 0) {
            req.setAttribute("msg", "添加成功");
        } else {
            req.setAttribute("msg", "添加失败");
        }
        // 转至下一视图
        req.getRequestDispatcher("/questionnaire/questionnairelist").forward(req, resp);
    }
}
