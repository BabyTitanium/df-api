package com.dongfan.dongfanapi.entity;

import java.util.Date;

public class BookErrata {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Date createAt;

    private Integer status;

    private String auditReplay;

    public BookErrata(Integer id, Integer userId, Integer bookId, Date createAt, Integer status, String auditReplay) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.createAt = createAt;
        this.status = status;
        this.auditReplay = auditReplay;
    }

    public BookErrata() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditReplay() {
        return auditReplay;
    }

    public void setAuditReplay(String auditReplay) {
        this.auditReplay = auditReplay == null ? null : auditReplay.trim();
    }
}