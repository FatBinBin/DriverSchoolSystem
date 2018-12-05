package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.mapper.DssLeaveWordMapper;
import com.bin.design.drivingschool.service.LeaveWordService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public PageBean<Map<String, Object>> getAll(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageBean<>(dssLeaveWordMapper.selectAll());
	}
}
