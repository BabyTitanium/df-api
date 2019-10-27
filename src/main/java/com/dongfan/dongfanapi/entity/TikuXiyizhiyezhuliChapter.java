package com.dongfan.dongfanapi.entity;

public class TikuXiyizhiyezhuliChapter {
    private Integer id;

    private Integer chapterParentId;

    private String title;

    private Integer sort;

    private Integer chapterId;

    public TikuXiyizhiyezhuliChapter(Integer id, Integer chapterParentId, String title, Integer sort, Integer chapterId) {
        this.id = id;
        this.chapterParentId = chapterParentId;
        this.title = title;
        this.sort = sort;
        this.chapterId = chapterId;
    }

    public TikuXiyizhiyezhuliChapter() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }
}