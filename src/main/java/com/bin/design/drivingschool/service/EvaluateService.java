package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssEvaluate;
import com.bin.design.drivingschool.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */


public interface EvaluateService {

	void insertEvalute(DssEvaluate dssEvaluate);

	PageBean<Map<String,Object>> selectEvalutes(Integer pageNum, Integer pageSize, Integer coachId, String key);

	void deleteById(Integer id);

	void deleteBatchById(List list);

}
