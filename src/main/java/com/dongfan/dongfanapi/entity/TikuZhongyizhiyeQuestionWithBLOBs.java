package com.dongfan.dongfanapi.entity;

public class TikuZhongyizhiyeQuestionWithBLOBs extends TikuZhongyizhiyeQuestion {
    private String restore;

    private String explain;

    private String option;

    public TikuZhongyizhiyeQuestionWithBLOBs(Integer id, Integer questionId, Integer chapterId, Integer chapterParentId, String title, String titleImg, Integer sNum, String number, String year, String questionType, String unit, String numberNumber, String syllabus, String explainImg, Integer type, String answer, Integer mediaId, String mediaUrl, String mediaImg, String restore, String explain, String option) {
        super(id, questionId, chapterId, chapterParentId, title, titleImg, sNum, number, year, questionType, unit, numberNumber, syllabus, explainImg, type, answer, mediaId, mediaUrl, mediaImg);
        this.restore = restore;
        this.explain = explain;
        this.option = option;
    }

    public TikuZhongyizhiyeQuestionWithBLOBs() {
        super();
    }

    public String getRestore() {
        return restore;
    }

    public void setRestore(String restore) {
        this.restore = restore == null ? null : restore.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option == null ? null : option.trim();
    }
}