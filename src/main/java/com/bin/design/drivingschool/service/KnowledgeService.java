package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.util.PageBean;

import java.util.Map;

/**
 * @author huangyubin
 * @version 2019/1/3
 * @since
 */
public interface KnowledgeService {

	PageBean<Map<String,Object>> selectCoaches(Integer pageNum, Integer pageSize, String key);

}
