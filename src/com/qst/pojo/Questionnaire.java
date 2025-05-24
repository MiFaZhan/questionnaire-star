package com.qst.pojo;
/**
 *
 * @author qst
 *
 * 问卷实体类
 *
 */
public class Questionnaire {
    private Integer questionnaireId;
    private String questionnaireTitle;
    private Integer questionnaireTypeId;
    public Questionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Questionnaire(Integer questionnaireId, String questionnaireTitle, Integer questionnaireTypeId) {
        super();
        this.questionnaireId = questionnaireId;
        this.questionnaireTitle = questionnaireTitle;
        this.questionnaireTypeId = questionnaireTypeId;
    }
    public Integer getQuestionnaireId() {
        return questionnaireId;
    }
    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }
    public Integer getQuestionnaireTypeId() {
        return questionnaireTypeId;
    }
    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }
    public void setQuestionnaireTypeId(Integer questionnaireTypeId) {
        this.questionnaireTypeId = questionnaireTypeId;
    }
    @Override
    public String toString() {
        return "Questionnaire [questionnaireId=" + questionnaireId + ", questionnaireTitle=" + questionnaireTitle
                + ", questionnaireTypeId=" + questionnaireTypeId + "]";
    }
}
