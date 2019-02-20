package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssDrivingKnowledge;
import com.bin.design.drivingschool.entity.DssKnowledgeComment;
import com.bin.design.drivingschool.entity.DssKnowledgeReply;
import com.bin.design.drivingschool.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2019/1/3
 * @since
 */
public interface KnowledgeService {

	PageBean<Map<String,Object>> selectKnowledge(Integer pageNum, Integer pageSize, String key);

	DssDrivingKnowledge selectById(Integer id);

	void insert(DssDrivingKnowledge dssDrivingKnowledge);

	void delete(Integer id);

	void deleteBatch(List list);

	void update(DssDrivingKnowledge dssDrivingKnowledge);

	PageBean<Map<String, Object>> selectComment(Integer pageNum, Integer pageSize, Integer id);

	int insertComment(DssKnowledgeComment dssKnowledgeComment);

	int updateCommentStatus(DssKnowledgeComment dssKnowledgeComment);

	int insertReply(DssKnowledgeReply dssKnowledgeReply);



}
