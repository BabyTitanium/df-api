package com.dongfan.dongfanapi.entity;

public class Live {
    private Integer id;

    private String startTime;

    private String title;

    private String url;

    private String thumb;

    private String poster;

    private String content;

    public Live(Integer id, String startTime, String title, String url, String thumb, String poster) {
        this.id = id;
        this.startTime = startTime;
        this.title = title;
        this.url = url;
        this.thumb = thumb;
        this.poster = poster;
    }

    public Live(Integer id, String startTime, String title, String url, String thumb, String poster, String content) {
        this.id = id;
        this.startTime = startTime;
        this.title = title;
        this.url = url;
        this.thumb = thumb;
        this.poster = poster;
        this.content = content;
    }

    public Live() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}