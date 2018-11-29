package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DssCoachInfo {

    private Integer id;

    private String coachName;

    private String coachSex;

    private String learnerIdcar;

    private Integer coachYear;

    private String coachPhone;

    private String coachIntro;

    private String coachImg;

    private Integer orderCount;
}