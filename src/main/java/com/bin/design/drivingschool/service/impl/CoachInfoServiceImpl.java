package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssCoachInfo;
import com.bin.design.drivingschool.mapper.DssCoachInfoMapper;
import com.bin.design.drivingschool.service.CoachInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	public List<DssCoachInfo> selectCoaches() {
		return dssCoachInfoMapper.selectAll();
	}

	@Override
	public DssCoachInfo selectCoachById(int id) {
		return dssCoachInfoMapper.selectByPrimaryKey(id);
	}
}
