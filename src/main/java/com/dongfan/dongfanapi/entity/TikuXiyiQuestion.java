package com.dongfan.dongfanapi.entity;

public class TikuXiyiQuestion {
    private Integer id;

    private Integer chapterId;

    private Integer chapterParentId;

    private String title;

    private String titleImg;

    private Integer sNum;

    private String number;

    private String year;

    private String questionType;

    private String numberNumber;

    private String syllabus;

    private String explainImg;

    private Integer type;

    private String answer;

    private Integer mediaId;

    private String mediaUrl;

    private String mediaImg;

    private Integer isHighTest;

    public TikuXiyiQuestion(Integer id, Integer questionId, Integer chapterId, Integer chapterParentId, String title, String titleImg, Integer sNum, String number, String year, String questionType, String numberNumber, String syllabus, String explainImg, Integer type, String answer, Integer mediaId, String mediaUrl, String mediaImg, Integer isHighTest) {
        this.id = id;
        this.chapterId = chapterId;
        this.chapterParentId = chapterParentId;
        this.title = title;
        this.titleImg = titleImg;
        this.sNum = sNum;
        this.number = number;
        this.year = year;
        this.questionType = questionType;
        this.numberNumber = numberNumber;
        this.syllabus = syllabus;
        this.explainImg = explainImg;
        this.type = type;
        this.answer = answer;
        this.mediaId = mediaId;
        this.mediaUrl = mediaUrl;
        this.mediaImg = mediaImg;
        this.isHighTest = isHighTest;
    }

    public TikuXiyiQuestion() {
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

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg == null ? null : titleImg.trim();
    }

    public Integer getsNum() {
        return sNum;
    }

    public void setsNum(Integer sNum) {
        this.sNum = sNum;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public String getNumberNumber() {
        return numberNumber;
    }

    public void setNumberNumber(String numberNumber) {
        this.numberNumber = numberNumber == null ? null : numberNumber.trim();
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus == null ? null : syllabus.trim();
    }

    public String getExplainImg() {
        return explainImg;
    }

    public void setExplainImg(String explainImg) {
        this.explainImg = explainImg == null ? null : explainImg.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

    public String getMediaImg() {
        return mediaImg;
    }

    public void setMediaImg(String mediaImg) {
        this.mediaImg = mediaImg == null ? null : mediaImg.trim();
    }

    public Integer getIsHighTest() {
        return isHighTest;
    }

    public void setIsHighTest(Integer isHighTest) {
        this.isHighTest = isHighTest;
    }
}