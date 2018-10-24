package com.bin.design.drivingschool.mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DssCoachInfo {

    private int id;

    private String coachName;

    private String coachSex;

    private int coachYear;

    private int coachPhone;

    private String coachIntro;

    private String coachImg;

    private int orderCount;
}
