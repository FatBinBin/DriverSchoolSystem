package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssCoachInfo;

import java.util.List;
import java.util.Map;

public interface DssCoachInfoMapper {

    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @return
     */
    int deleteBatchByPrimaryKey(List list);

    int insert(DssCoachInfo record);

    int insertSelective(DssCoachInfo record);

    List<Map<String, Object>> selectAll();

    List<Map<String,Object>> selectByKey(String key);

    DssCoachInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DssCoachInfo record);

    int updateByPrimaryKey(DssCoachInfo record);
}