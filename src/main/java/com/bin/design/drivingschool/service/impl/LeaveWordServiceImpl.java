package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssLeaveWord;
import com.bin.design.drivingschool.mapper.DssLeaveWordMapper;
import com.bin.design.drivingschool.service.LeaveWordService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/12/5
 * @since
 */
@Service
public class LeaveWordServiceImpl implements LeaveWordService {

	@Autowired
	DssLeaveWordMapper dssLeaveWordMapper;

	@Override
	public void insert(DssLeaveWord dssLeaveWord) {
		dssLeaveWordMapper.insertSelective(dssLeaveWord);
	}

	@Override
	public PageBean<Map<String, Object>> getAll(Integer pageNum, Integer pageSize , String key) {
		PageHelper.startPage(pageNum,pageSize);
		if (StringUtils.isEmpty(key)) {
			return new PageBean<>(dssLeaveWordMapper.selectAll());
		}
		return new PageBean<>(dssLeaveWordMapper.selectByKey(key));
	}

	@Override
	public void deleteById(Integer id) {
		dssLeaveWordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateWords(DssLeaveWord dssLeaveWord) {
		dssLeaveWordMapper.updateByPrimaryKeySelective(dssLeaveWord);
	}

	@Override
	public void deleteBatchById(List list) {
		dssLeaveWordMapper.deleteBatchByPrimaryKey(list);
	}
}
