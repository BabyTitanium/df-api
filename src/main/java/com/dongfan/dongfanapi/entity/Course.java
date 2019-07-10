package com.dongfan.dongfanapi.entity;

import java.util.Date;

public class Course {
    private Integer id;

    private String title;

    private Date createAt;

    private Date updateAt;

    private Integer auth;

    private Integer status;

    private String content;

    public Course(Integer id, String title, Date createAt, Date updateAt, Integer auth, Integer status) {
        this.id = id;
        this.title = title;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.auth = auth;
        this.status = status;
    }

    public Course(Integer id, String title, Date createAt, Date updateAt, Integer auth, Integer status, String content) {
        this.id = id;
        this.title = title;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.auth = auth;
        this.status = status;
        this.content = content;
    }

    public Course() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}