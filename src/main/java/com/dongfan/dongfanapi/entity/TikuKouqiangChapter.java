package com.dongfan.dongfanapi.entity;

public class TikuKouqiangChapter {
    private Integer id;

    private Integer chapterId;

    private Integer chapterParentId;

    private String title;

    private Integer sort;

    public TikuKouqiangChapter(Integer id, Integer chapterId, Integer chapterParentId, String title, Integer sort) {
        this.id = id;
        this.chapterId = chapterId;
        this.chapterParentId = chapterParentId;
        this.title = title;
        this.sort = sort;
    }

    public TikuKouqiangChapter() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getChapterParentId() {
        return chapterParentId;
    }

    public void setChapterParentId(Integer chapterParentId) {
        this.chapterParentId = chapterParentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}