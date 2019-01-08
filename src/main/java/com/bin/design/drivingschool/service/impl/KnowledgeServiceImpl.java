package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssDrivingKnowledge;
import com.bin.design.drivingschool.mapper.DssDrivingKnowledgeMapper;
import com.bin.design.drivingschool.service.KnowledgeService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2019/1/3
 * @since
 */

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

	@Autowired
	DssDrivingKnowledgeMapper dssDrivingKnowledgeMapper;

	@Override
	public DssDrivingKnowledge selectById(Integer id) {
		return dssDrivingKnowledgeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insert(DssDrivingKnowledge dssDrivingKnowledge) {
		dssDrivingKnowledgeMapper.insertSelective(dssDrivingKnowledge);
	}

	@Override
	public void update(DssDrivingKnowledge dssDrivingKnowledge) {
		dssDrivingKnowledgeMapper.updateByPrimaryKeySelective(dssDrivingKnowledge);
	}

	@Override
	public void delete(Integer id) {
		dssDrivingKnowledgeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteBatch(List list) {

	}

	@Override
	public PageBean<Map<String, Object>> selectCoaches(Integer pageNum, Integer pageSize, String key) {
		PageHelper.startPage(pageNum, pageSize);
		if (StringUtils.isEmpty(key)) {
			return new PageBean<>(dssDrivingKnowledgeMapper.selectAll());
		}
		return new PageBean<>(dssDrivingKnowledgeMapper.selectByKey(key));
	}
}
