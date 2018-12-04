package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssCoachInfo;
import com.bin.design.drivingschool.mapper.DssCoachInfoMapper;
import com.bin.design.drivingschool.service.CoachInfoService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
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

	@Override
	public PageBean<Map<String,Object>> selectCoaches(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageBean<>(dssCoachInfoMapper.selectAll());
	}

	@Override
	public DssCoachInfo selectCoachById(int id) {
		return dssCoachInfoMapper.selectByPrimaryKey(id);
	}
}
