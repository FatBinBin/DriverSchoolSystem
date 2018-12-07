package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssAppointmentDriving;
import com.bin.design.drivingschool.mapper.DssAppointmentDrivingMapper;
import com.bin.design.drivingschool.service.AppointmentDrivingService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppointmentDrivingServiceImpl implements AppointmentDrivingService {

    @Autowired
    DssAppointmentDrivingMapper dssAppointmentDrivingMapper;

    @Override
    public void deleteById(Integer id) {
        dssAppointmentDrivingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateAppointment(DssAppointmentDriving dssAppointmentDriving) {
        dssAppointmentDrivingMapper.updateByPrimaryKeySelective(dssAppointmentDriving);
    }

    @Override
    public void deleteBatchById(List list) {
        dssAppointmentDrivingMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public PageBean<Map<String, Object>> getAll(Integer pageNum, Integer pageSize, String key) {
        PageHelper.startPage(pageNum,pageSize);
        if (StringUtils.isEmpty(key)) {
            return new PageBean<>(dssAppointmentDrivingMapper.selectAll());
        }
        return new PageBean<>(dssAppointmentDrivingMapper.selectByKey(key));
    }
}
