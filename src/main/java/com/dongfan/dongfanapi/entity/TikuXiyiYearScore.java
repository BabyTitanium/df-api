package com.dongfan.dongfanapi.entity;

public class TikuXiyiYearScore {
    private Integer id;

    private String year;

    private String qnum;

    private Float qscore;

    public TikuXiyiYearScore(Integer id, String year, String qnum, Float qscore) {
        this.id = id;
        this.year = year;
        this.qnum = qnum;
        this.qscore = qscore;
    }

    public TikuXiyiYearScore() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getQnum() {
        return qnum;
    }

    public void setQnum(String qnum) {
        this.qnum = qnum == null ? null : qnum.trim();
    }

    public Float getQscore() {
        return qscore;
    }

    public void setQscore(Float qscore) {
        this.qscore = qscore;
    }
}