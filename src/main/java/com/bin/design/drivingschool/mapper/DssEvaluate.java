package com.bin.design.drivingschool.mapper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DssEvaluate {

    private int id;

    private int coachId;

    private String evaluateContent;

    private byte evaluate;

    private int learner;
}
