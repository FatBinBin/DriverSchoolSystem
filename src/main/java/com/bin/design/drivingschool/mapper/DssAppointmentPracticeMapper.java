package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssAppointmentPractice;
import org.apache.ibatis.annotations.Param;

import javax.management.ObjectName;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DssAppointmentPracticeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssAppointmentPractice record);

    int insertSelective(DssAppointmentPractice record);

    List<Map<String, Object>> selectAll();

    List<Map<String, Object>> selectByName(String key);

    List<DssAppointmentPractice> selectByLearnerId(Integer learnerId);

    List<DssAppointmentPractice> selectByLearnerIdAndTime(@Param("learnerId") Integer learnerId,
                                                    @Param("appointmentTime") Date appointmentTime);

    Map<String, Object> checkAppointment(@Param("coachId") Integer coachId, @Param("appointmentTime") String appointmentTime,
                                         @Param("moment") Byte moment);

    List<Map<String, Object>> selectCoachAppointment(@Param("coachId") Integer coachId, @Param("appointmentTime") String appointmentTime,
                                         @Param("moment") Byte moment);

    int updateByPrimaryKeySelective(DssAppointmentPractice record);

    int updateByPrimaryKey(DssAppointmentPractice record);
}