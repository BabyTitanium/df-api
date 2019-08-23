package com.dongfan.dongfanapi.entity;

import java.util.Date;

public class BookErrataWithBLOBs extends BookErrata {
    private String content;

    private String images;

    public BookErrataWithBLOBs(Integer id, Integer userId, Integer bookId, Date createAt, Integer status, String auditReplay, String content, String images) {
        super(id, userId, bookId, createAt, status, auditReplay);
        this.content = content;
        this.images = images;
    }

    public BookErrataWithBLOBs() {
        super();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
     public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }
}