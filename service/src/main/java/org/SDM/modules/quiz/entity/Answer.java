package org.SDM.modules.quiz.entity;

import org.SDM.common.mybatis.domain.Entity;

public class Answer extends Entity {

    private String answerId;



    /**
     * Teacher(T), Student(S)
     */
    private String answerType;

    private String quizId;

    /**
     * UUID
     */
    private String picture;

    private String feedback;

    private boolean approved;

    private String mostMistakes;

    private int mistakesCount;

    public String getAnswerId() {
        return answerId;
    }

    @Override
    public void setId(String answerId){
        super.setId(answerId);
        this.answerId = answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getMostMistakes() {
        return mostMistakes;
    }

    public void setMostMistakes(String mostMistakes) {
        this.mostMistakes = mostMistakes;
    }

    public int getMistakesCount() {
        return mistakesCount;
    }

    public void setMistakesCount(int mistakesCount) {
        this.mistakesCount = mistakesCount;
    }
}
