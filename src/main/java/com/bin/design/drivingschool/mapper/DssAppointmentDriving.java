package com.bin.design.drivingschool.mapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DssAppointmentDriving {

    private int id;

    private String appointmentName;

    private int idCard;

    private int phonenum;

    private byte appointmentStatus;
}
