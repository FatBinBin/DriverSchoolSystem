package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssLearnerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DssLearnerInfoMapper {

    /**
     *
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @return
     */
    int deleteBatchByPrimaryKey(List list);

    int insert(DssLearnerInfo record);

    int insertSelective(DssLearnerInfo record);

    int batchInsert(List<DssLearnerInfo> dssLearnerInfos);

    /**
     *
     * @return
     */
    List<Map<String,Object>> selectAll();

    List<Map<String,Object>> selectByKey(String key);

    List<Map<String,Object>> selectLearnerForCoach(Integer id);

    DssLearnerInfo findByLearnerPhone(String learnerPhone);

    DssLearnerInfo findByLearnerIdcar(String learnerIdcar);

    List<Map<String, Object>> selectAllProcessing();

    Map<String, Object> selectLearnerBySession(@Param("begin")String begin, @Param("end")String end);

//    DssLearnerInfo findLearnerByPhone(String learnerPhone);
    /**
     *
     * @param id
     * @return
     */
    DssLearnerInfo selectByPrimaryKey(Integer id);

    /**
     *
     */
    Map<String, Object> selectInfoByPrimaryKey(Integer id);

    Map<String, Object> selectProcessedByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DssLearnerInfo record);

    int updateByPrimaryKey(DssLearnerInfo record);
}