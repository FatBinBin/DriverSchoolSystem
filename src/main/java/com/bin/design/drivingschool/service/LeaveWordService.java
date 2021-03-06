package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssLeaveWord;
import com.bin.design.drivingschool.util.PageBean;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/12/5
 * @since
 */
public interface LeaveWordService {

	PageBean<Map<String,Object>> getAll(Integer pageNum, Integer pageSize , String key);

	void insert(DssLeaveWord dssLeaveWord);

	void deleteById(Integer id);

	void deleteBatchById(List list);

	void updateWords(DssLeaveWord dssLeaveWord);



}
