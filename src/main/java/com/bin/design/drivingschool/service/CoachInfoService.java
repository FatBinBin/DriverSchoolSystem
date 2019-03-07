package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssCoachInfo;
import com.bin.design.drivingschool.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */
public interface CoachInfoService {

	PageBean<Map<String,Object>> selectCoaches(Integer pageNum,Integer pageSize, String key);

	List<Map<String, Object>> selectCoachIdAndName();

	Map<String, Object> selectCoachById(int id);

	PageBean<Map<String,Object>> selectLearnerForCoach(Integer pageNum,Integer pageSize,Integer id);

	List<Map<String, Object>> countLearnerNum();

	void updateById(DssCoachInfo dssCoachInfo);

	void insert(DssCoachInfo dssCoachInfo);

	void deleteById(Integer id);

	void deleteBatchById(List list);

	PageBean<Map<String,Object>> getCoachForm(Integer pageNum, Integer pageSize, Integer season);
}
