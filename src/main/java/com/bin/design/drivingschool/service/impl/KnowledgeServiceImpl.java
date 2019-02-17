package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssDrivingKnowledge;
import com.bin.design.drivingschool.entity.DssKnowledgeComment;
import com.bin.design.drivingschool.mapper.DssDrivingKnowledgeMapper;
import com.bin.design.drivingschool.mapper.DssKnowledgeCommentMapper;
import com.bin.design.drivingschool.service.KnowledgeService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
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
	@Autowired
	DssKnowledgeCommentMapper dssKnowledgeCommentMapper;

	@Override
	public DssDrivingKnowledge selectById(Integer id) {
		return dssDrivingKnowledgeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insert(DssDrivingKnowledge dssDrivingKnowledge) {
		dssDrivingKnowledgeMapper.insertSelective(dssDrivingKnowledge);
	}

	@Override
	public int insertComment(DssKnowledgeComment dssKnowledgeComment) {
		return dssKnowledgeCommentMapper.insertSelective(dssKnowledgeComment);
	}

	@Override
	public PageBean<Map<String, Object>> selectComment(Integer pageNum, Integer pageSize, Integer id) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageBean<>(dssKnowledgeCommentMapper.selectCommentByLearner(id));
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
	public PageBean<Map<String, Object>> selectKnowledge(Integer pageNum, Integer pageSize, String key) {
		PageHelper.startPage(pageNum, pageSize);
		if (StringUtils.isEmpty(key)) {
			return new PageBean<>(dssDrivingKnowledgeMapper.selectAll());
		}
		return new PageBean<>(dssDrivingKnowledgeMapper.selectByKey(key));
	}
}
