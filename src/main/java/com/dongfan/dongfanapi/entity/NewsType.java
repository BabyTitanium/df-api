package com.dongfan.dongfanapi.entity;

public class NewsType {
    private Integer id;

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