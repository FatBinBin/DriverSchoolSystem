package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DssAppointmentPractice {

    private Integer id;

    private Integer learnerId;

    private String learnerName;

    private String learnerPhone;

    private Byte learnerSex;

    private Integer learnerAge;

    private String learnerIdcar;

    private Integer coachId;

    private Byte course;

    private Date appointmentTime;

    private Byte type;

    private Byte status;

}