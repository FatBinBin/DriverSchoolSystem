package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssAppointmentPractice;
import com.bin.design.drivingschool.util.PageBean;

import java.util.Map;

public interface AppointmentPracticeService {

    int insert(DssAppointmentPractice dssAppointmentPractice);

    PageBean<DssAppointmentPractice> selectAppointmentRecord(Integer pageNum, Integer pageSize, Integer learnerId);

    int updataById(DssAppointmentPractice dssAppointmentPractice);

    int deleteById(Integer id);
}
