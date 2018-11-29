package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.mapper.DssLearnerInfoMapper;
import com.bin.design.drivingschool.service.LearnerInfoService;
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
public class LearnerInfoServiceImpl implements LearnerInfoService {

	@Autowired
	DssLearnerInfoMapper dssLearnerInfoMapper;

	@Override
	public List<DssLearnerInfo> selectAllLearner() {
		return dssLearnerInfoMapper.selectAll();
	}

	@Override
	public Map<String, Object> selectProcessedById(int id) {
		return dssLearnerInfoMapper.selectProcessedByPrimaryKey(id);
	}

	@Override
	public DssLearnerInfo selectById(int id) {
		return dssLearnerInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateById(DssLearnerInfo dssLearnerInfo) {
		dssLearnerInfoMapper.updateByPrimaryKeySelective(dssLearnerInfo);

	}
}
