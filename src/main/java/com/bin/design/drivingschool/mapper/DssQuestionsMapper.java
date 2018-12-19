package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssQuestions;
import com.bin.design.drivingschool.util.PageBean;

import java.util.Map;

public interface DssQuestionsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssQuestions record);

    int insertSelective(DssQuestions record);

    DssQuestions selectByPrimaryKey(Integer id);

    PageBean<Map<String, Object>> selectByType(Byte type);

    int updateByPrimaryKeySelective(DssQuestions record);

    int updateByPrimaryKeyWithBLOBs(DssQuestions record);

    int updateByPrimaryKey(DssQuestions record);
}