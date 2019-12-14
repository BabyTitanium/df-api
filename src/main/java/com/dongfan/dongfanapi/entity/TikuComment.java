package com.dongfan.dongfanapi.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TikuComment {
    private Integer id;
    @NotNull
    @NotEmpty
    private String content;

    @NotNull
    @NotEmpty
    private String tikuName;
    @NotNull
    @Range(min = 1)
    private Integer questionId;

    private Date createAt;


    private Integer userId;

    private Integer likes;

    private  Integer status;
    public TikuComment(Integer id, String content, String tikuName, Integer questionId, Date createAt, Integer userId, Integer likes) {
        this.id = id;
        this.content = content;
        this.tikuName = tikuName;
        this.questionId = questionId;
        this.createAt = createAt;
        this.userId = userId;
        this.likes = likes;
    }

    public TikuComment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}