package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssNotice;
import com.bin.design.drivingschool.mapper.DssNoticeMapper;
import com.bin.design.drivingschool.service.NoticeService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    DssNoticeMapper dssNoticeMapper;

    @Override
    public void update(DssNotice dssNotice) {
        dssNoticeMapper.updateByPrimaryKeySelective(dssNotice);
    }

    @Override
    public void insert(DssNotice dssNotice) {
        dssNoticeMapper.insertSelective(dssNotice);
    }

    @Override
    public void batchDelete(List id) {
        dssNoticeMapper.batchDeleteById(id);
    }

    @Override
    public void delete(Integer id) {
        dssNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBean<Map<String, Object>> getAll(Integer pageNum, Integer pageSize, String key) {
        PageHelper.startPage(pageNum,pageSize);
        if (StringUtils.isEmpty(key)) {
            return new PageBean<>(dssNoticeMapper.selectAll());
        }
        return new PageBean<>(dssNoticeMapper.selectAllByKey(key));
    }
}
