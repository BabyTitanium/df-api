package com.dongfan.dongfanapi.entity;

public class Book {
    private Integer id;

    private String title;

    private String describe;

    private String cover;

    private String author;

    public Book(Integer id, String title, String describe, String cover, String author) {
        this.id = id;
        this.title = title;
        this.describe = describe;
        this.cover = cover;
        this.author = author;
    }

    public Book() {
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }
}