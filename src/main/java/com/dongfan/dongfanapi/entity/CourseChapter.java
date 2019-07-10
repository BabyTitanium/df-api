package com.dongfan.dongfanapi.entity;

import java.util.Date;

public class CourseChapter {
    private Long id;

    private Integer courseId;

    private String title;

    private String url;

    private Integer status;

    private Integer type;

    private String smeta;

    private Integer hits;

    private Integer sort;

    private Integer likes;

    private Date createAt;

    private Date updateAt;

    private Integer parentId;

    private String content;

    public CourseChapter(Long id, Integer courseId, String title, String url, Integer status, Integer type, String smeta, Integer hits, Integer sort, Integer likes, Date createAt, Date updateAt, Integer parentId) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.url = url;
        this.status = status;
        this.type = type;
        this.smeta = smeta;
        this.hits = hits;
        this.sort = sort;
        this.likes = likes;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.parentId = parentId;
    }

    public CourseChapter(Long id, Integer courseId, String title, String url, Integer status, Integer type, String smeta, Integer hits, Integer sort, Integer likes, Date createAt, Date updateAt, Integer parentId, String content) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.url = url;
        this.status = status;
        this.type = type;
        this.smeta = smeta;
        this.hits = hits;
        this.sort = sort;
        this.likes = likes;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.parentId = parentId;
        this.content = content;
    }

    public CourseChapter() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSmeta() {
        return smeta;
    }

    public void setSmeta(String smeta) {
        this.smeta = smeta == null ? null : smeta.trim();
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}