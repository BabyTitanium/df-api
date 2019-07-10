package com.dongfan.dongfanapi.entity;

public class TikuXiyizhiyeQuestionWithBLOBs extends TikuXiyizhiyeQuestion {
    private String restore;

    private String explain;

    private String option;

    private String knowledge;

    private String restoren;

    private String explainn;

    public TikuXiyizhiyeQuestionWithBLOBs(Integer id, Integer questionId, Integer chapterId, Integer chapterParentId, String title, String titleImg, Integer sNum, String number, String year, String questionType, String unit, String numberNumber, String syllabus, String explainImg, Integer type, String answer, Integer mediaId, String mediaUrl, String mediaImg, String knowledgeImg, String restore, String explain, String option, String knowledge, String restoren, String explainn) {
        super(id, questionId, chapterId, chapterParentId, title, titleImg, sNum, number, year, questionType, unit, numberNumber, syllabus, explainImg, type, answer, mediaId, mediaUrl, mediaImg, knowledgeImg);
        this.restore = restore;
        this.explain = explain;
        this.option = option;
        this.knowledge = knowledge;
        this.restoren = restoren;
        this.explainn = explainn;
    }

    public TikuXiyizhiyeQuestionWithBLOBs() {
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

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
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