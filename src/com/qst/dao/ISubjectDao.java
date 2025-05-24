package com.qst.dao;

import com.qst.pojo.Subject;

import java.util.List;

/**
 *
 * @author qst
 *
 * 题目数据访问接口
 *
 */
public interface ISubjectDao {
    /**
     * 查询指定试卷的题目
     * @param userId
     * @return
     */
    List<Subject> listSubject(Integer questionnaireId);
    /**
     * 添加题目
     * @param subject
     * @return
     */
    int addSubject(Subject subject);
}
