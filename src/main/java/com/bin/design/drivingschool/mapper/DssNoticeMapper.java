package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssNotice;

import java.util.List;
import java.util.Map;

public interface DssNoticeMapper {

    int deleteByPrimaryKey(Integer id);

    int batchDeleteById(List list);

    int insert(DssNotice record);

    int insertSelective(DssNotice record);

    DssNotice selectByPrimaryKey(Integer id);

    List<Map<String, Object>> selectAll();

    List<Map<String,Object>> selectAllByKey(String key);

    int updateByPrimaryKeySelective(DssNotice record);

    int updateByPrimaryKeyWithBLOBs(DssNotice record);

    int updateByPrimaryKey(DssNotice record);
}