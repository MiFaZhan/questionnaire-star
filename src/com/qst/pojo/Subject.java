package com.qst.pojo;
/**
 *
 * @author qst
 *
 * 题目实体类
 *
 */
public class Subject {
    private String choiceFour;
    private String choiceOne;
    private String choiceThree;
    private String choiceTwo;
    private Integer questionnaireId;
    private Integer subjectId;
    private String subjectTitle;
    public Subject() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Subject(Integer subjectId, String subjectTitle, String choiceOne, String choiceTwo, String choiceThree,
                   String choiceFour, Integer questionnaireId) {
        super();
        this.subjectId = subjectId;
        this.subjectTitle = subjectTitle;
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
        this.choiceThree = choiceThree;
        this.choiceFour = choiceFour;
        this.questionnaireId = questionnaireId;
    }
    public String getChoiceFour() {
        return choiceFour;
    }
    public String getChoiceOne() {
        return choiceOne;
    }
    public String getChoiceThree() {
        return choiceThree;
    }
    public String getChoiceTwo() {
        return choiceTwo;
    }
    public Integer getQuestionnaireId() {
        return questionnaireId;
    }
    public Integer getSubjectId() {
        return subjectId;
    }
    public String getSubjectTitle() {
        return subjectTitle;
    }
    public void setChoiceFour(String choiceFour) {
        this.choiceFour = choiceFour;
    }
    public void setChoiceOne(String choiceOne) {
        this.choiceOne = choiceOne;
    }
    public void setChoiceThree(String choiceThree) {
        this.choiceThree = choiceThree;
    }
    public void setChoiceTwo(String choiceTwo) {
        this.choiceTwo = choiceTwo;
    }
    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }
    @Override
    public String toString() {
        return "Subject [subjectId=" + subjectId + ", subjectTitle=" + subjectTitle + ", choiceOne=" + choiceOne
                + ", choiceTwo=" + choiceTwo + ", choiceThree=" + choiceThree + ", choiceFour=" + choiceFour
                + ", questionnaireId=" + questionnaireId + "]";
    }
}

