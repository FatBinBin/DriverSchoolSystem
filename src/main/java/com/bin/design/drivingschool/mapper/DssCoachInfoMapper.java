package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssCoachInfo;

import java.util.List;

public interface DssCoachInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssCoachInfo record);

    int insertSelective(DssCoachInfo record);

    List<DssCoachInfo> selectAll();

    DssCoachInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DssCoachInfo record);

    int updateByPrimaryKey(DssCoachInfo record);
}