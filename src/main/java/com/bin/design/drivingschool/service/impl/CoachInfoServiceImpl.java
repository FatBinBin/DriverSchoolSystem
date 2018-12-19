package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssCoachInfo;
import com.bin.design.drivingschool.mapper.DssCoachInfoMapper;
import com.bin.design.drivingschool.mapper.DssLearnerInfoMapper;
import com.bin.design.drivingschool.service.CoachInfoService;
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
public class CoachInfoServiceImpl implements CoachInfoService {

	@Autowired
	DssCoachInfoMapper dssCoachInfoMapper;
	@Autowired
	DssLearnerInfoMapper dssLearnerInfoMapper;

	@Override
	public PageBean<Map<String,Object>> selectCoaches(Integer pageNum, Integer pageSize,String key) {
		PageHelper.startPage(pageNum,pageSize);
		if (StringUtils.isEmpty(key)){
		return new PageBean<>(dssCoachInfoMapper.selectAll());
		}
		return new PageBean<>(dssCoachInfoMapper.selectByKey(key));

	}

	@Override
	public void updateById(DssCoachInfo dssCoachInfo) {
		dssCoachInfoMapper.updateByPrimaryKeySelective(dssCoachInfo);
	}

	@Override
	public void insert(DssCoachInfo dssCoachInfo) {
		dssCoachInfoMapper.insertSelective(dssCoachInfo);
	}

	@Override
	public void deleteById(Integer id) {
		dssCoachInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteBatchById(List list) {
		dssCoachInfoMapper.deleteBatchByPrimaryKey(list);
	}

	@Override
	public List<Map<String, Object>> selectCoachIdAndName() {
		return dssCoachInfoMapper.selectIdAndName();
	}

	@Override
	public DssCoachInfo selectCoachById(int id) {
		return dssCoachInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageBean<Map<String, Object>> selectLearnerForCoach(Integer pageNum, Integer pageSize, Integer id) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageBean<>(dssLearnerInfoMapper.selectLearnerForCoach(id));
	}
}
