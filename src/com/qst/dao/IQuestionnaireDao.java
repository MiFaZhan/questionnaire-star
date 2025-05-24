package com.qst.dao;

import com.qst.pojo.Questionnaire;

import java.util.List;

/**
 *
 * @author qst
 *
 * 问卷数据访问接口
 *
 */
public interface IQuestionnaireDao {
    /**
     * 根据类型查询问卷数量
     * @return
     */
    List<Integer> queryNumByType();
    /**
     * 查询指定类型的问卷
     * @param userId
     * @return
     */
    List<Questionnaire> listAllQuestionnaire(Integer questionnaireId);

    /**
     * 添加问卷
     * @param questionnaire
     * @return
     */
    int addQuestionnaire(Questionnaire questionnaire);
}
