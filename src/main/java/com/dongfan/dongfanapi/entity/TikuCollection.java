package com.dongfan.dongfanapi.entity;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TikuCollection {

    private Integer id;

    @NotEmpty
    @NotNull
    private String tikuName;

    @Range(min = 1)
    @NotNull
    private Integer questionId;

    private Date createAt;


    private Integer userId;

    public TikuCollection(Integer id, String tikuName, Integer questionId, Date createAt, Integer userId) {
        this.id = id;
        this.tikuName = tikuName;
        this.questionId = questionId;
        this.createAt = createAt;
        this.userId = userId;
    }

    public TikuCollection() {
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}