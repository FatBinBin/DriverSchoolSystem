package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssEvaluate;
import com.bin.design.drivingschool.mapper.DssEvaluateMapper;
import com.bin.design.drivingschool.service.EvaluateService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public PageBean<Map<String, Object>> selectEvalutes(Integer pageNum, Integer pageSize, Integer coachId) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageBean<>(dssEvaluateMapper.selectByCoachId(coachId));
	}

	@Override
	public void insertEvalute(DssEvaluate dssEvaluate) {
		dssEvaluateMapper.insertSelective(dssEvaluate);
	}
}
