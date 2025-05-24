package com.qst.service;

import com.qst.dao.*;
import com.qst.pojo.*;
import com.qst.util.DBUtil;
import com.qst.util.MD5;
import java.util.List;

public class QuestionnaireServiceImpl implements IQuestionnaireService {

    private final IUserDao userDao;
    private final IQuestionnaireTypeDao questionnaireTypeDao;
    private final IQuestionnaireDao questionnaireDao;
    private final ISubjectDao subjectDao;

    public QuestionnaireServiceImpl() {
        this.userDao = new UserDaoImpl();
        this.questionnaireTypeDao = new QuestionnaireTypeDaoImpl();
        this.questionnaireDao = new QuestionnaireDaoImpl();
        this.subjectDao = new SubjectDaoImpl();
    }

    @Override
    public User verifyLogin(String uname, String upass) {
        String encrypted = MD5.enctypeMD5(uname + upass);
        return userDao.verifyLogin(uname, encrypted);
    }

    @Override
    public List<QuestionnaireType> listAllQuestionnaireType() {
        return questionnaireTypeDao.listAllQuestionnaireType();
    }

    @Override
    public List<Questionnaire> listAllQuestionnaire(Integer questionnaireTypeId) {
        return questionnaireDao.listAllQuestionnaire(questionnaireTypeId);
    }

    @Override
    public int addQuestionnaire(Questionnaire questionnaire) {
        return questionnaireDao.addQuestionnaire(questionnaire);
    }

    @Override
    public List<Subject> listSubject(Integer questionnaireId) {
        return subjectDao.listSubject(questionnaireId);
    }

    @Override
    public int addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    @Override
    public List<Integer> queryNumByType() {
        return questionnaireDao.queryNumByType();
    }
}
