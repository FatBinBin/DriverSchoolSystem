package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssLearnerInfo;

import java.util.List;
import java.util.Map;

public interface DssLearnerInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DssLearnerInfo record);

    int insertSelective(DssLearnerInfo record);

    /**
     *
     * @return
     */
    List<DssLearnerInfo> selectAll();

    /**
     *
     * @param id
     * @return
     */
    DssLearnerInfo selectByPrimaryKey(Integer id);

    /**
     *
     */
    Map<String, Object> selectProcessedByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DssLearnerInfo record);

    int updateByPrimaryKey(DssLearnerInfo record);
}