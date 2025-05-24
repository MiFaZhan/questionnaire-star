package com.qst.web;

import com.qst.pojo.QuestionnaireType;
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
 * 显示问卷类型列表
 */
@WebServlet("/questionnaire/questionnairetypelist")
public class QuestionnaireTypeListAction extends HttpServlet {
    private IQuestionnaireService questionaireService;

    public QuestionnaireTypeListAction() {
        questionaireService = new QuestionnaireServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<QuestionnaireType> questionnaireTypeList = questionaireService.listAllQuestionnaireType();
        if (questionnaireTypeList.size() > 0) {
            req.setAttribute("questionnaireTypeList", questionnaireTypeList);
        } else {
            req.setAttribute("msg", "当前没有数据存在");
        }
        req.getRequestDispatcher("/questionnairetype_list.jsp").forward(req, resp);
    }
}
