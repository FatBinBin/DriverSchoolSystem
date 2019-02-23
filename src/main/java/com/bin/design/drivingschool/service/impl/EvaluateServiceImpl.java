package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssEvaluate;
import com.bin.design.drivingschool.mapper.DssEvaluateMapper;
import com.bin.design.drivingschool.service.EvaluateService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {

	@Autowired
	DssEvaluateMapper dssEvaluateMapper;

	@Override
	public void deleteById(Integer id) {
		dssEvaluateMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int upateById(DssEvaluate dssEvaluate) {
		return dssEvaluateMapper.updateByPrimaryKeySelective(dssEvaluate);
	}

	@Override
	public void deleteBatchById(List list) {
		dssEvaluateMapper.deleteBatchByPrimaryKey(list);
	}

	@Override
	public PageBean<Map<String, Object>> selectComplaintByLearner(Integer pageNum, Integer pageSize, Integer learnerId) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageBean<>(dssEvaluateMapper.selectComplaintByLearner(learnerId));
	}

	@Override
	public List<Map<String, Object>> recommendByOrderCount() {
		return dssEvaluateMapper.selectByOrderCount();
	}

	@Override
	public List<Map<String, Object>> recommendByEvaluateType() {
		return dssEvaluateMapper.selectByEvaluateType();
	}

	@Override
	public PageBean<Map<String, Object>> selectEvalutesByLearner(Integer pageNum, Integer pageSize, Integer learnerId) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageBean<>(dssEvaluateMapper.selectByLearner(learnerId));
	}

	@Override
	public PageBean<Map<String, Object>> selectAllEvalutes(Integer pageNum, Integer pageSize,  String key) {
		PageHelper.startPage(pageNum,pageSize);
		if (StringUtils.isNotEmpty(key)){
			return new PageBean<>(dssEvaluateMapper.selectAllEvaluateByKey(key));
		}
		return new PageBean<>(dssEvaluateMapper.selectAllEvaluate());
	}

	@Override
	public PageBean<Map<String, Object>> selectComplaint(Integer pageNum, Integer pageSize, String key) {
		PageHelper.startPage(pageNum,pageSize);
		if (StringUtils.isNotEmpty(key)){
			return new PageBean<>(dssEvaluateMapper.selectAlComplaintByKey(key));
		}
		return new PageBean<>(dssEvaluateMapper.selectAllComplaint());
	}

	@Override
	public PageBean<Map<String, Object>> selectEvalutes(Integer pageNum, Integer pageSize, Integer coachId, String key) {
		PageHelper.startPage(pageNum,pageSize);
		if (coachId != null){
			return new PageBean<>(dssEvaluateMapper.selectByCoachId(coachId));
		}else if (StringUtils.isNotEmpty(key)){
			return new PageBean<>(dssEvaluateMapper.selectAllByKey(key));
		}
		return new PageBean<>(dssEvaluateMapper.selectAll());
	}

	@Override
	public void insertEvalute(DssEvaluate dssEvaluate) {
		dssEvaluateMapper.insertSelective(dssEvaluate);
	}
}
