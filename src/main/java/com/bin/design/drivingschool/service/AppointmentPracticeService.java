package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssAppointmentPractice;
import com.bin.design.drivingschool.util.PageBean;

import javax.crypto.interfaces.PBEKey;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface AppointmentPracticeService {

    int insert(DssAppointmentPractice dssAppointmentPractice);

    PageBean<Map<String, Object>> selectAll(Integer pageNum, Integer pageSize, String key);

    PageBean<DssAppointmentPractice> selectAppointmentRecord(Integer pageNum, Integer pageSize, Integer learnerId);

    Map<String, Object> checkAppointment(Integer coachId, String appointmentTime, Byte moment);

    PageBean<Map<String, Object>> selectCoachAppointment(Integer pageNum, Integer pageSize,
                                                         Integer coachId, String appointmentTime, Byte moment);

    int updataById(DssAppointmentPractice dssAppointmentPractice);

    int deleteById(Integer id);

    void deleteBatchById(List list);
}
