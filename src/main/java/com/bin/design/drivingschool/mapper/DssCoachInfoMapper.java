package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssCoachInfo;
import org.apache.ibatis.annotations.Param;

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

    List<Map<String,Object>> selectByName(String key);

    List<Map<String, Object>> selectIdAndName();

    Map<String, Object> selectByPrimaryKey(Integer id);

    List<Map<String, Object>> countLearnerNum();

    int updateByPrimaryKeySelective(DssCoachInfo record);

    int updateByPrimaryKey(DssCoachInfo record);

    List<Map<String, Object>> coachForm(@Param("beginTime") String beginTime,
                                        @Param("endTime") String endTime);
}