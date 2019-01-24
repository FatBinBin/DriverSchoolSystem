package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.mapper.DssLearnerInfoMapper;
import com.bin.design.drivingschool.service.LearnerInfoService;
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
public class LearnerInfoServiceImpl implements LearnerInfoService {

	@Autowired
	DssLearnerInfoMapper dssLearnerInfoMapper;

	@Override
	public PageBean<Map<String,Object>> selectAllLearner(Integer pageNum,Integer pageSize,String learnerName) {
		PageHelper.startPage(pageNum, pageSize);
		if (StringUtils.isEmpty(learnerName)) {
		return new PageBean<>(dssLearnerInfoMapper.selectAll());
		}
		return new PageBean<>(dssLearnerInfoMapper.selectByKey(learnerName));
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
	public void deleteBatchById(List list) {
		dssLearnerInfoMapper.deleteBatchByPrimaryKey(list);
	}

	@Override
	public void deleteById(Integer id) {
		dssLearnerInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(DssLearnerInfo dssLearnerInfo) {
		dssLearnerInfoMapper.insertSelective(dssLearnerInfo);
	}

	@Override
	public DssLearnerInfo selectLearnerByPhone(String learnerPhone) {
		return dssLearnerInfoMapper.findByLearnerPhone(learnerPhone);
	}

	@Override
	public DssLearnerInfo selectByLearnerPhone(DssLearnerInfo dssLearnerInfo) {
		return dssLearnerInfoMapper.findByLearnerPhone(dssLearnerInfo.getLearnerPhone());
	}

	@Override
	public void updateById(DssLearnerInfo dssLearnerInfo) {
		dssLearnerInfoMapper.updateByPrimaryKeySelective(dssLearnerInfo);

	}
}
