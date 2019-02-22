package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssAppointmentPractice;
import com.bin.design.drivingschool.mapper.DssAppointmentPracticeMapper;
import com.bin.design.drivingschool.service.AppointmentPracticeService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
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
    public PageBean<Map<String, Object>> selectCoachAppointment(Integer pageNum, Integer pageSize,
                                                                Integer coachId, String appointmentTime, Byte moment) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(dssAppointmentPracticeMapper.selectCoachAppointment(coachId, appointmentTime, moment));
    }

    @Override
    public int updataById(DssAppointmentPractice dssAppointmentPractice) {
        return dssAppointmentPracticeMapper.updateByPrimaryKeySelective(dssAppointmentPractice);
    }

    @Override
    public PageBean<Map<String, Object>> selectAll(Integer pageNum, Integer pageSize, String key) {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isEmpty(key)){
        return new PageBean<>(dssAppointmentPracticeMapper.selectAll());
        }
        return new PageBean<>(dssAppointmentPracticeMapper.selectByName(key));
    }

    @Override
    public Map<String, Object> checkAppointment(Integer coachId, String appointmentTime, Byte moment) {
        return dssAppointmentPracticeMapper.checkAppointment(coachId, appointmentTime, moment);
    }

    @Override
    public PageBean<DssAppointmentPractice> selectAppointmentRecord(Integer pageNum, Integer pageSize, Integer learnerId) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(dssAppointmentPracticeMapper.selectByLearnerId(learnerId));
    }

    @Override
    public int insert(DssAppointmentPractice dssAppointmentPractice) {
        if (dssAppointmentPractice.getLearnerId() != null){
        int learnerId = dssAppointmentPractice.getLearnerId();
        Date appointmentTime = dssAppointmentPractice.getAppointmentTime();
        Byte type = dssAppointmentPractice.getType();
        List<DssAppointmentPractice> check = dssAppointmentPracticeMapper.selectByLearnerIdAndTime(learnerId,appointmentTime,type);
        if (check != null && check.size() >= 2){
            return -1;
        }else if (check !=null && check.size() == 1 && check.get(0).getMoment() == dssAppointmentPractice.getMoment()){
            return -1;
        }
        }else if (dssAppointmentPractice.getLearnerPhone() != null){
            String learnerName = dssAppointmentPractice.getLearnerName();
            String learnerPhone = dssAppointmentPractice.getLearnerPhone();
            Date appointmentTime = dssAppointmentPractice.getAppointmentTime();
            Byte type = dssAppointmentPractice.getType();
            List<DssAppointmentPractice> check1 = dssAppointmentPracticeMapper.selectByLearnerNameAndPhoneAndTime(
                    learnerName, learnerPhone, appointmentTime, type);
            if (check1 != null && check1.size() >= 2){
                return -1;
            }else if (check1 !=null && check1.size() == 1 && check1.get(0).getMoment() == dssAppointmentPractice.getMoment()){
                return -1;
            }
        }
        return dssAppointmentPracticeMapper.insertSelective(dssAppointmentPractice);
    }
}
