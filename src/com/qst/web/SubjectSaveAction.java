package com.qst.web;


import com.qst.service.IQuestionnaireService;
import com.qst.service.QuestionnaireServiceImpl;
import com.qst.util.ParseUtil;
import com.qst.pojo.Subject; // 确保包路径与你的项目结构一致

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
 * 题目新增
 *
 */
@WebServlet("/questionnaire/subjectsave")
public class SubjectSaveAction extends HttpServlet {

    private IQuestionnaireService questionaireService;
    public SubjectSaveAction() {
        questionaireService=new QuestionnaireServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        Integer questionnaireId
                = ParseUtil.parseToInteger(req.getParameter("questionnaireId"));
        String choiceOne=req.getParameter("choiceOne");
        String choiceTwo=req.getParameter("choiceTwo");
        String choiceThree=req.getParameter("choiceThree");
        String choiceFour=req.getParameter("choiceFour");
        String subjectTitle=req.getParameter("subjectTitle");
        // 组装数据
        Subject subject = new Subject();
        subject.setSubjectTitle(subjectTitle);
        subject.setChoiceFour(choiceFour);
        subject.setChoiceOne(choiceOne);
        subject.setChoiceThree(choiceThree);
        subject.setChoiceTwo(choiceTwo);
        subject.setQuestionnaireId(questionnaireId);
        // 完成业务
        int rows = questionaireService.addSubject(subject);
        if (rows > 0) {
            req.setAttribute("msg", "添加成功");
        } else {
            req.setAttribute("msg", "添加失败");
        }
        // 转至下一视图
        req.getRequestDispatcher("/questionnaire/subjectlist").forward(req, resp);
    }
}
