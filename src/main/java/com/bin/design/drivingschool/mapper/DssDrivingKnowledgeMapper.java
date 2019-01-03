package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssDrivingKnowledge;

public interface DssDrivingKnowledgeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssDrivingKnowledge record);

    int insertSelective(DssDrivingKnowledge record);

    DssDrivingKnowledge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DssDrivingKnowledge record);

    int updateByPrimaryKeyWithBLOBs(DssDrivingKnowledge record);

    int updateByPrimaryKey(DssDrivingKnowledge record);
}