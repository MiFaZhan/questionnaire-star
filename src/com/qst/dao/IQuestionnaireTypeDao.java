package com.qst.dao;

import com.qst.pojo.QuestionnaireType;

import java.util.List;

/**
 *
 * @author qst
 *
 * 问卷类型数据访问类
 *
 */
public interface IQuestionnaireTypeDao {

    /**
     * 查询所有问卷类型
     * @param userId
     * @return
     */
    List<QuestionnaireType> listAllQuestionnaireType();

}
