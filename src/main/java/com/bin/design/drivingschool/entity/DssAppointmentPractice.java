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

    private Boolean learnerSex;

    private Integer learnerAge;

    private String learnerIdcar;

    private Integer coachId;

    private Boolean course;

    private Date appointmentTime;

    private Boolean moment;

    private Boolean type;

    private Boolean status;

    private Boolean read;

}