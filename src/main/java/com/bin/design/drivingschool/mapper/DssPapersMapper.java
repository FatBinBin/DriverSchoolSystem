package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssPapers;

import javax.management.ObjectName;
import java.util.List;
import java.util.Map;

public interface DssPapersMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssPapers record);

    int insertSelective(DssPapers record);

    DssPapers selectByPrimaryKey(Integer id);

    List<Map<String, Object>> selectAll();

    List<Map<String, Object>> selectByType(Byte type);

    int updateByPrimaryKeySelective(DssPapers record);

    int updateByPrimaryKeyWithBLOBs(DssPapers record);

    int updateByPrimaryKey(DssPapers record);

    //逻辑删除
    int updateStateById(Integer id);

    int updateBatchStateById(List list);
}