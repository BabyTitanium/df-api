package com.dongfan.dongfanapi.entity;

public class TikuXiyizhiyezhuliQuestionWithBLOBs extends TikuXiyizhiyezhuliQuestion {
    private String restore;

    private String explain;

    private String option;

    private String restoren;

    private String explainn;

    private String knowledge;

    public TikuXiyizhiyezhuliQuestionWithBLOBs(Integer id, Integer questionId, Integer chapterId, Integer chapterParentId, String title, String titleImg, Integer sNum, String number, String year, String questionType, String numberNumber, String recovery, String syllabus, String explainImg, Integer type, String answer, Integer mediaId, String mediaUrl, String mediaImg, String knowledgeImg, String unit, String restore, String explain, String option, String restoren, String explainn, String knowledge) {
        super(id, questionId, chapterId, chapterParentId, title, titleImg, sNum, number, year, questionType, numberNumber, recovery, syllabus, explainImg, type, answer, mediaId, mediaUrl, mediaImg, knowledgeImg, unit);
        this.restore = restore;
        this.explain = explain;
        this.option = option;
        this.restoren = restoren;
        this.explainn = explainn;
        this.knowledge = knowledge;
    }

    public TikuXiyizhiyezhuliQuestionWithBLOBs() {
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

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
    }
}