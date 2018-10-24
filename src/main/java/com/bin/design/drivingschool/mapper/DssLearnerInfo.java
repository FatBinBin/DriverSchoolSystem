package com.bin.design.drivingschool.mapper;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class DssLearnerInfo {

    private int id;

    private String learnerName;

    private byte learnerSex;

    private int learnerAge;

    private int learnerPhone;

    private String learnerAddress;

    private int learnerIDcard;

    private int processoing;

    private int coachId;

    private Date createTime;

    private Date updateTime;
}
