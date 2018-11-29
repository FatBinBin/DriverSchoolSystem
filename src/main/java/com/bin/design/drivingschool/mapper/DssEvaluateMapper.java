package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssEvaluate;

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

    int updateByPrimaryKeySelective(DssEvaluate record);

    int updateByPrimaryKey(DssEvaluate record);
}