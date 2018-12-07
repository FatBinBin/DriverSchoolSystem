package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DssAppointmentDriving {

    private Integer id;

    private String appointmentName;

    private String idcard;

    private String phone;

    private Byte status;
}