package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DssLearnerInfo {

    private Integer id;

    private String learnerName;

    private Byte learnerSex;

    private Integer learnerAge;

    private String learnerPhone;

    private String learnerAddress;

    private String learnerIdcar;

    private Byte processing;

    private Integer coachId;

    private Date createTime;

    private Date updateTime;
}