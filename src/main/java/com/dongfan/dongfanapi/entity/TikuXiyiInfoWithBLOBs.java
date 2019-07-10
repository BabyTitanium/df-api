package com.dongfan.dongfanapi.entity;

public class TikuXiyiInfoWithBLOBs extends TikuXiyiInfo {
    private String restore;

    private String recovery;

    private String explain;

    private String option;

    private String restoren;

    private String explainn;

    public TikuXiyiInfoWithBLOBs(Integer id, Integer questionId, Integer chapterId, Integer chapterParentId, String title, String titleImg, Integer sNum, String number, String year, String questionType, String numberNumber, String syllabus, String explainImg, Integer type, String answer, Integer mediaId, String mediaUrl, String mediaImg, Integer isHighTest, String chapterName, String restore, String recovery, String explain, String option, String restoren, String explainn) {
        super(id, questionId, chapterId, chapterParentId, title, titleImg, sNum, number, year, questionType, numberNumber, syllabus, explainImg, type, answer, mediaId, mediaUrl, mediaImg, isHighTest, chapterName);
        this.restore = restore;
        this.recovery = recovery;
        this.explain = explain;
        this.option = option;
        this.restoren = restoren;
        this.explainn = explainn;
    }

    public TikuXiyiInfoWithBLOBs() {
        super();
    }

    public String getRestore() {
        return restore;
    }

    public void setRestore(String restore) {
        this.restore = restore == null ? null : restore.trim();
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery == null ? null : recovery.trim();
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

    public String getRestoren() {
        return restoren;
    }

    public void setRestoren(String restoren) {
        this.restoren = restoren == null ? null : restoren.trim();
    }

    public String getExplainn() {
        return explainn;
    }

    public void setExplainn(String explainn) {
        this.explainn = explainn == null ? null : explainn.trim();
    }
}