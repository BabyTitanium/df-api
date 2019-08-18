package com.dongfan.dongfanapi.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewsType {
    private Integer id;
    @NotNull
    @NotEmpty
    private String title;

    public NewsType(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public NewsType() {
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
}