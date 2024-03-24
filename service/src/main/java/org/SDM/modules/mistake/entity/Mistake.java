package org.SDM.modules.mistake.entity;

import org.SDM.common.mybatis.domain.Entity;

public class Mistake extends Entity {

    private String mistakeId;

    private String answerId;

    private String feedbackNumbers;

    private Boolean recent;

    @Override
    public void setId(String mistakeId){
        super.setId(mistakeId);
        this.mistakeId = mistakeId;
    }

    public String getMistakeId() {
        return mistakeId;
    }

    public void setMistakeId(String mistakeId) {
        this.mistakeId = mistakeId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getFeedbackNumbers() {
        return feedbackNumbers;
    }

    public void setFeedbackNumbers(String feedbackNumbers) {
        this.feedbackNumbers = feedbackNumbers;
    }

    public Boolean getRecent() {
        return recent;
    }

    public void setRecent(Boolean recent) {
        this.recent = recent;
    }
}
