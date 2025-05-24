package com.qst.pojo;
/**
 *
 * @author qst
 *
 * 问卷类型实体类
 *
 */
public class QuestionnaireType {
    private String questionnaireTypeDesc;
    private Integer questionnaireTypeId;
    public QuestionnaireType() {
        super();
        // TODO Auto-generated constructor stub
    }
    public QuestionnaireType(Integer questionnaireTypeId, String questionnaireTypeDesc) {
        super();
        this.questionnaireTypeId = questionnaireTypeId;
        this.questionnaireTypeDesc = questionnaireTypeDesc;
    }
    public String getQuestionnaireTypeDesc() {
        return questionnaireTypeDesc;
    }
    public Integer getQuestionnaireTypeId() {
        return questionnaireTypeId;
    }
    public void setQuestionnaireTypeDesc(String questionnaireTypeDesc) {
        this.questionnaireTypeDesc = questionnaireTypeDesc;
    }
    public void setQuestionnaireTypeId(Integer questionnaireTypeId) {
        this.questionnaireTypeId = questionnaireTypeId;
    }
    @Override
    public String toString() {
        return "QuestionnaireType [questionnaireTypeId=" + questionnaireTypeId + ", questionnaireTypeDesc="
                + questionnaireTypeDesc + "]";
    }
}
