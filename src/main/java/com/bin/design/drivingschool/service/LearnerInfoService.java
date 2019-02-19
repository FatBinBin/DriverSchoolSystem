package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */
public interface LearnerInfoService {

	PageBean<Map<String,Object>> selectAllLearner(Integer pageNum,Integer pageSize,String key);

	DssLearnerInfo selectById(int id);

	Map<String, Object> selectProcessedById(int id);

	DssLearnerInfo selectByLearnerPhone(DssLearnerInfo learnerInfo);

	DssLearnerInfo selectLearnerByPhone(String learnerPhone);

	DssLearnerInfo selectLearnerByIdcar(String learnerIdcar);

	Map<String, Object> selectAllProsessing();

	Map<String, Object> selectLearnerBySession();

	Map<String, Object> selectLearnerByYear();

	Map<String, Object> selectTitleById(Integer id);

	void updateById(DssLearnerInfo dssLearnerInfo);

	int updateTitleById(Integer title, Integer id);

	void insert(DssLearnerInfo dssLearnerInfo);

	int batchInsert(List<DssLearnerInfo> dssLearnerInfos);

	void deleteById(Integer id);

	void deleteBatchById(List list);

}
