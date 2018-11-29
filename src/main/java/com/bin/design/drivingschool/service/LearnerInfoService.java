package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssLearnerInfo;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */
public interface LearnerInfoService {

	List<DssLearnerInfo> selectAllLearner();

	DssLearnerInfo selectById(int id);

	Map<String, Object> selectProcessedById(int id);

	void updateById(DssLearnerInfo dssLearnerInfo);

}
