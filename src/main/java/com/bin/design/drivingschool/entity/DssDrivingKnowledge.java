package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DssDrivingKnowledge {

    private Integer id;

    private String knowledgeTopic;

    private String knowledgeFrom;

    private String knowledgeContent;

    private String knowledgeImg;

    private Date createTime;

    private Date updateTime;

}