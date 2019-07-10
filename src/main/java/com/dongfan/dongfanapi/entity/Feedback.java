package com.dongfan.dongfanapi.entity;

public class Feedback {
    private Integer id;

    private String title;

    private Integer userId;

    private Integer createAt;

    private String repely;

    private String content;

    public Feedback(Integer id, String title, Integer userId, Integer createAt, String repely) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.createAt = createAt;
        this.repely = repely;
    }

    public Feedback(Integer id, String title, Integer userId, Integer createAt, String repely, String content) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.createAt = createAt;
        this.repely = repely;
        this.content = content;
    }

    public Feedback() {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Integer createAt) {
        this.createAt = createAt;
    }

    public String getRepely() {
        return repely;
    }

    public void setRepely(String repely) {
        this.repely = repely == null ? null : repely.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}