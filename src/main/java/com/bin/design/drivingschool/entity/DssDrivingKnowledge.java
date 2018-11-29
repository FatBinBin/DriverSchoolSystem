package com.bin.design.drivingschool.entity;

public class DssDrivingKnowledge {

    private Integer id;

    private String knowledgeTopic;

    private String knowledgeContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKnowledgeTopic() {
        return knowledgeTopic;
    }

    public void setKnowledgeTopic(String knowledgeTopic) {
        this.knowledgeTopic = knowledgeTopic == null ? null : knowledgeTopic.trim();
    }

    public String getKnowledgeContent() {
        return knowledgeContent;
    }

    public void setKnowledgeContent(String knowledgeContent) {
        this.knowledgeContent = knowledgeContent == null ? null : knowledgeContent.trim();
    }
}