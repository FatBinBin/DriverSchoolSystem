package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DssNotice {

    private Integer id;

    private String noticeTopic;

    private String author;

    private Date createTime;

    private Date updateTime;

    private String noticeContent;


}