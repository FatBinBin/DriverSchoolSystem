package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssAppointmentPractice;
import com.bin.design.drivingschool.mapper.DssAppointmentPracticeMapper;
import com.bin.design.drivingschool.service.AppointmentPracticeService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentPracticeServiceImpl implements AppointmentPracticeService {

    @Autowired
    DssAppointmentPracticeMapper dssAppointmentPracticeMapper;

    @Override
    public int deleteById(Integer id) {
        return dssAppointmentPracticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updataById(DssAppointmentPractice dssAppointmentPractice) {
        return dssAppointmentPracticeMapper.updateByPrimaryKeySelective(dssAppointmentPractice);
    }

    @Override
    public PageBean<DssAppointmentPractice> selectAppointmentRecord(Integer pageNum, Integer pageSize, Integer learnerId) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(dssAppointmentPracticeMapper.selectByLearnerId(learnerId));
    }

    @Override
    public int insert(DssAppointmentPractice dssAppointmentPractice) {
        int learnerId = dssAppointmentPractice.getLearnerId();
        Date appointmentTime = dssAppointmentPractice.getAppointmentTime();
        List<DssAppointmentPractice> check = dssAppointmentPracticeMapper.selectByLearnerIdAndTime(learnerId,appointmentTime);
        if (check != null && check.size() == 2){
            return -1;
        }else if (check !=null && check.size() == 1 && check.get(0).getMoment() == dssAppointmentPractice.getMoment()){
            return -1;
        }
        return dssAppointmentPracticeMapper.insertSelective(dssAppointmentPractice);
    }
}
