package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DssQuestions {

    private Integer id;

    private String answer;

    private Byte state;

    private Byte type;

    private String question;


}