package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.constant.ExamEnum;
import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.mapper.DssLearnerInfoMapper;
import com.bin.design.drivingschool.service.LearnerInfoService;
import com.bin.design.drivingschool.util.PageBean;
import com.bin.design.drivingschool.util.SeasonUtils;
import com.github.pagehelper.PageHelper;
import org.apache.catalina.manager.util.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	public int batchInsert(List<DssLearnerInfo> dssLearnerInfos) {
		return dssLearnerInfoMapper.batchInsert(dssLearnerInfos);
	}

	@Override
	public int updateTitleById(Integer title, Integer id) {
		return dssLearnerInfoMapper.updateTitleByPrimaryKey(title, id);
	}

	@Override
	public void insert(DssLearnerInfo dssLearnerInfo) {
		dssLearnerInfoMapper.insertSelective(dssLearnerInfo);
	}

	@Override
	public Map<String, Object> selectLearnerByYear() {
		Map<String, Object> result = new HashMap<>();
		result.put("one", dssLearnerInfoMapper.selectLearnerBySession(SeasonUtils.getSeasonCharDate(0, null)[0],
				SeasonUtils.getSeasonCharDate(0, null)[1]).get("num"));
		result.put("two", dssLearnerInfoMapper.selectLearnerBySession("2018-01-01",
				"2018-12-31").get("num"));
		return result;
	}

	@Override
	public Map<String, Object> selectLearnerBySession() {
		Map<String, Object> result = new HashMap<>();
		result.put("one", dssLearnerInfoMapper.selectLearnerBySession(SeasonUtils.getSeasonCharDate(1, null)[0],
				SeasonUtils.getSeasonCharDate(1, null)[1]).get("num"));
		result.put("two", dssLearnerInfoMapper.selectLearnerBySession(SeasonUtils.getSeasonCharDate(2, null)[0],
				SeasonUtils.getSeasonCharDate(2, null)[1]).get("num"));
		result.put("three", dssLearnerInfoMapper.selectLearnerBySession(SeasonUtils.getSeasonCharDate(3, null)[0],
				SeasonUtils.getSeasonCharDate(3, null)[1]).get("num"));
		result.put("four", dssLearnerInfoMapper.selectLearnerBySession(SeasonUtils.getSeasonCharDate(4, null)[0],
				SeasonUtils.getSeasonCharDate(4, null)[1]).get("num"));
		return result;
	}

	@Override
	public DssLearnerInfo selectLearnerByIdcar(String learnerIdcar) {
		return dssLearnerInfoMapper.findByLearnerIdcar(learnerIdcar);
	}

	@Override
	public Map<String, Object> selectAllProsessing() {
		List<Map<String, Object>> processed = dssLearnerInfoMapper.selectAllProcessing();
		Map<String, List<Map<String, Object>>> a = processed.stream()
				.collect(Collectors.groupingBy(o->o.get("processing").toString()));
		Map<String, Object> result = new HashMap<>();
		for (ExamEnum i : ExamEnum.values()){
			String num;
			String code = i.getCode();
			Map<String, Object> p = new HashMap<>();
			if (a.containsKey(code)){
				num = a.get(code).get(0).get("num").toString();
			}else {
				num = "0";
			}
			result.put(i.getName(), num);
		}
		return result;
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
	public Map<String, Object> selectTitleById(Integer id) {
		return dssLearnerInfoMapper.selectTitleById(id);
	}

	@Override
	public void updateById(DssLearnerInfo dssLearnerInfo) {
		dssLearnerInfoMapper.updateByPrimaryKeySelective(dssLearnerInfo);

	}
}
