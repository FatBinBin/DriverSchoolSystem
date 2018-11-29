package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssEvaluate;
import com.bin.design.drivingschool.mapper.DssEvaluateMapper;
import com.bin.design.drivingschool.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void insertEvalute(DssEvaluate dssEvaluate) {
		dssEvaluateMapper.insertSelective(dssEvaluate);
	}
}
