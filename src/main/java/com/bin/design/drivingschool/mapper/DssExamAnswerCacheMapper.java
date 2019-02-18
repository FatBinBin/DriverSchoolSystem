package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssExamAnswerCache;

public interface DssExamAnswerCacheMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssExamAnswerCache record);

    int insertSelective(DssExamAnswerCache record);

    DssExamAnswerCache selectByPrimaryKey(Integer id);

    DssExamAnswerCache selectByPaperId(Integer paparId);

    int truncateTable();

    int updateByPrimaryKeySelective(DssExamAnswerCache record);

    int updateByPrimaryKey(DssExamAnswerCache record);
}