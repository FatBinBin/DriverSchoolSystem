package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssEvaluate;

import java.util.List;
import java.util.Map;

public interface DssEvaluateMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssEvaluate record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(DssEvaluate record);

    DssEvaluate selectByPrimaryKey(Integer id);

    List<Map<String, Object>> selectByCoachId(Integer coachId);

    int updateByPrimaryKeySelective(DssEvaluate record);

    int updateByPrimaryKey(DssEvaluate record);
}