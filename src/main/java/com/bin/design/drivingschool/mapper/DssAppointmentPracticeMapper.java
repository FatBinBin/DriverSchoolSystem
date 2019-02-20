package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssAppointmentPractice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DssAppointmentPracticeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssAppointmentPractice record);

    int insertSelective(DssAppointmentPractice record);

    List<DssAppointmentPractice> selectByLearnerId(Integer learnerId);

    List<DssAppointmentPractice> selectByLearnerIdAndTime(@Param("learnerId") Integer learnerId,
                                                    @Param("appointmentTime") Date appointmentTime);

    int updateByPrimaryKeySelective(DssAppointmentPractice record);

    int updateByPrimaryKey(DssAppointmentPractice record);
}