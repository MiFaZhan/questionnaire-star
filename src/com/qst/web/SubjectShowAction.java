package com.qst.web;

import com.qst.service.IQuestionnaireService;
import com.qst.service.QuestionnaireServiceImpl;
import com.qst.util.ParseUtil;
import com.qst.pojo.Subject;
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
 * 显示指定问卷的题目
 *
 */
@WebServlet("/questionnaire/subjectshow")
public class SubjectShowAction extends HttpServlet {

    private IQuestionnaireService questionaireService;
    public SubjectShowAction() {
        questionaireService=new QuestionnaireServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionnaireId= ParseUtil.parseToInteger(req.getParameter("questionnaireId"));//取出问卷ID
        List<Subject> subjectList = questionaireService.listSubject(questionnaireId);//查出此问卷的所有题目
        if (subjectList.size() > 0) {
            req.setAttribute("subjectList", subjectList);
        } else {
            req.setAttribute("msg", "当前没有数据存在");
        }
        req.getRequestDispatcher("/subject_show.jsp").forward(req, resp);
    }
}
