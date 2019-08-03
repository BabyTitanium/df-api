package com.dongfan.dongfanapi.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TikuRecord {
    private Integer id;

    @NotNull
    @NotEmpty
    private String tikuName;

    @NotNull
    @NotEmpty
    private Integer questionId;

    @NotNull
    @NotEmpty
    private Integer userId;

    @NotNull
    @NotEmpty
    private Date createAt;

    @NotNull
    @NotEmpty
    private String answer;

    @NotNull
    @NotEmpty
    private String correctAnswer;
    @NotNull
    @NotEmpty
    private Integer result;

    public TikuRecord(Integer id, String tikuName, Integer questionId, Integer userId, Date createAt, String answer, String correctAnswer, Integer result) {
        this.id = id;
        this.tikuName = tikuName;
        this.questionId = questionId;
        this.userId = userId;
        this.createAt = createAt;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
        this.result = result;
    }

    public TikuRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTikuName() {
        return tikuName;
    }

    public void setTikuName(String tikuName) {
        this.tikuName = tikuName == null ? null : tikuName.trim();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer == null ? null : correctAnswer.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}