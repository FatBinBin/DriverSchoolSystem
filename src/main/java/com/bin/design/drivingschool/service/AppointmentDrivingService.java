package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssAppointmentDriving;
import com.bin.design.drivingschool.util.PageBean;

import java.util.List;
import java.util.Map;

public interface AppointmentDrivingService {

    PageBean<Map<String,Object>> getAll(Integer pageNum, Integer pageSize , String key);

    void deleteById(Integer id);

    void deleteBatchById(List list);

    void updateAppointment(DssAppointmentDriving dssAppointmentDriving);

}
