package com.dongfan.dongfanapi.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class News {
    private Integer id;

    @NotEmpty
    @NotNull
    private String title;
    @NotEmpty
    @NotNull
    private String thumb;
    @NotEmpty
    @NotNull
    private String poster;

    private Date createAt;

    private Date updateAt;
    @NotNull
    private Integer typeId;

    private Integer sort;
    @NotEmpty
    @NotNull
    private String smeta;
    @NotEmpty
    @NotNull
    private String content;

    public News(Integer id, String title, String thumb, String poster, Date createAt, Date updateAt, Integer typeId, Integer sort, String smeta) {
        this.id = id;
        this.title = title;
        this.thumb = thumb;
        this.poster = poster;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.typeId = typeId;
        this.sort = sort;
        this.smeta = smeta;
    }

    public News(Integer id, String title, String thumb, String poster, Date createAt, Date updateAt, Integer typeId, Integer sort, String smeta, String content) {
        this.id = id;
        this.title = title;
        this.thumb = thumb;
        this.poster = poster;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.typeId = typeId;
        this.sort = sort;
        this.smeta = smeta;
        this.content = content;
    }

    public News() {
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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb == null ? null : thumb.trim();
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster == null ? null : poster.trim();
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getSort(Integer sort) {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getSmeta() {
        return smeta;
    }

    public void setSmeta(String smeta) {
        this.smeta = smeta == null ? null : smeta.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}