package com.bin.design.drivingschool.entity;

public class DssNotice {

    private Integer id;

    private String noticeTopic;

    private String noticeContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeTopic() {
        return noticeTopic;
    }

    public void setNoticeTopic(String noticeTopic) {
        this.noticeTopic = noticeTopic == null ? null : noticeTopic.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }
}