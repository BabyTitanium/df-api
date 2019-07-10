package com.dongfan.dongfanapi.entity;

import java.util.Date;

public class Class {
    private Integer id;

    private String name;

    private Integer show;

    private Integer sort;

    private Date createAt;

    private Date updateAt;

    private String thumb;

    private String content;

    public Class(Integer id, String name, Integer show, Integer sort, Date createAt, Date updateAt, String thumb) {
        this.id = id;
        this.name = name;
        this.show = show;
        this.sort = sort;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.thumb = thumb;
    }

    public Class(Integer id, String name, Integer show, Integer sort, Date createAt, Date updateAt, String thumb, String content) {
        this.id = id;
        this.name = name;
        this.show = show;
        this.sort = sort;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.thumb = thumb;
        this.content = content;
    }

    public Class() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb == null ? null : thumb.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}