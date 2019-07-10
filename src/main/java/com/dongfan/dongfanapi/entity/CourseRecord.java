package com.dongfan.dongfanapi.entity;

import java.util.Date;

public class CourseRecord {
    private Integer id;

    private Integer courseId;

    private Integer userId;

    private Date createAt;

    private Integer time;

    public CourseRecord(Integer id, Integer courseId, Integer userId, Date createAt, Integer time) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.createAt = createAt;
        this.time = time;
    }

    public CourseRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}