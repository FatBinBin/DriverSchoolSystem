package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssDrivingKnowledge;

import java.util.List;
import java.util.Map;

public interface DssDrivingKnowledgeMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteBatchByPrimaryKey(List list);

    int insert(DssDrivingKnowledge record);

    int insertSelective(DssDrivingKnowledge record);

    DssDrivingKnowledge selectByPrimaryKey(Integer id);

	List<Map<String, Object>> selectAll();

	List<Map<String,Object>> selectByKey(String key);

    int updateByPrimaryKeySelective(DssDrivingKnowledge record);

    int updateByPrimaryKeyWithBLOBs(DssDrivingKnowledge record);

    int updateByPrimaryKey(DssDrivingKnowledge record);
}