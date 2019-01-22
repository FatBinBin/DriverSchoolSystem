package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssKnowledgeComment;

import java.util.List;
import java.util.Map;

public interface DssKnowledgeCommentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssKnowledgeComment record);

    int insertSelective(DssKnowledgeComment record);

    DssKnowledgeComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DssKnowledgeComment record);

    int updateByPrimaryKey(DssKnowledgeComment record);

    List<Map<String,Object>> selectCommentByLearner(Integer id);
}