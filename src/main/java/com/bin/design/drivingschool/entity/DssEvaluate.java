package com.bin.design.drivingschool.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DssEvaluate {

    private Integer id;

    private Integer coachId;

    private String content;

    private Byte type;

    private Integer leanerId;

}