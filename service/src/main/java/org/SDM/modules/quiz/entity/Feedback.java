package org.SDM.modules.quiz.entity;

import org.SDM.common.mybatis.domain.Entity;

public class Feedback extends Entity {


    private String feedbackId;
    private String quizId;

    private String feedbackNumber;

    private String feedbackText;

    public String getFeedbackId(){
        return feedbackId;
    }

    @Override
    public void setId(String feedbackId){
        super.setId(feedbackId);
        this.feedbackId = feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getFeedbackNumber() {
        return feedbackNumber;
    }

    public void setFeedbackNumber(String feedbackNumber) {
        this.feedbackNumber = feedbackNumber;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
}
