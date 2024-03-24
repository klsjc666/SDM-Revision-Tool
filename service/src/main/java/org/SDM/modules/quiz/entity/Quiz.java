package org.SDM.modules.quiz.entity;

import org.SDM.common.mybatis.domain.Entity;


public class Quiz extends Entity {

    private String quizId;


    private String quizName;


    private String quizQuestion;

    private String quizType;

    public String getQuizId() {
        return quizId;
    }

    @Override
    public void setId(String quizId) {
        super.setId(quizId);
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quiz_name) {
        this.quizName = quiz_name;
    }

    public String getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(String quiz_question) {
        this.quizQuestion = quiz_question;
    }

    public String getQuizType() {
        return quizType;
    }

    public void setQuizType(String quizType) {
        this.quizType = quizType;
    }
}
