package com.qst.service;

import com.qst.pojo.Questionnaire;
import com.qst.pojo.QuestionnaireType;
import com.qst.pojo.Subject;
import com.qst.pojo.User;
import java.util.List;

/**
 * @author qst
 * 问卷业务逻辑接口
 */
public interface IQuestionnaireService {

    // --- 用户相关 ---
    /**
     * 用户登录验证
     * @param uname 用户名
     * @param upass 密码（明文）
     * @return 用户对象/null
     */
    User verifyLogin(String uname, String upass);

    // --- 问卷类型相关 ---
    /**
     * 获取所有问卷类型
     * @return 问卷类型列表
     */
    List<QuestionnaireType> listAllQuestionnaireType();

    // --- 问卷管理相关 ---
    /**
     * 获取指定类型的问卷列表
     * @param questionnaireTypeId 问卷类型ID
     * @return 问卷列表
     */
    List<Questionnaire> listAllQuestionnaire(Integer questionnaireTypeId);

    /**
     * 添加新问卷
     * @param questionnaire 问卷对象
     * @return 受影响行数
     */
    int addQuestionnaire(Questionnaire questionnaire);

    // --- 题目管理相关 ---
    /**
     * 获取指定问卷的题目列表
     * @param questionnaireId 问卷ID
     * @return 题目列表
     */
    List<Subject> listSubject(Integer questionnaireId);

    /**
     * 添加新题目
     * @param subject 题目对象
     * @return 受影响行数
     */
    int addSubject(Subject subject);

    // --- 统计相关 ---
    /**
     * 按类型统计问卷数量
     * @return 数量列表（索引对应类型ID）
     */
    List<Integer> queryNumByType();
}
