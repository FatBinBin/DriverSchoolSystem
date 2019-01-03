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
	public void deleteBatchById(List list) {
		dssEvaluateMapper.deleteBatchByPrimaryKey(list);
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
