package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssEvaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DssEvaluateMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteBatchByPrimaryKey(List list);

    int insert(DssEvaluate record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(DssEvaluate record);

    DssEvaluate selectByPrimaryKey(Integer id);

    List<Map<String, Object>> selectByCoachId(Integer coachId);

    List<Map<String, Object>> selectAll();

    List<Map<String, Object>> selectAllByKey(String key);

    List<Map<String, Object>> selectByOrderCount();

    List<Map<String, Object>> selectByEvaluateType();

    List<Map<String, Object>> selectByLearner(@Param("learnerId")Integer learnerId);

    List<Map<String, Object>> selectComplaintByLearner(@Param("learnerId")Integer learnerId);

    int updateByPrimaryKeySelective(DssEvaluate record);

    int updateByPrimaryKey(DssEvaluate record);
}