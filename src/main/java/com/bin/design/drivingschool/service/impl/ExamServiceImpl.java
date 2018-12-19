package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssPapers;
import com.bin.design.drivingschool.mapper.DssPapersMapper;
import com.bin.design.drivingschool.service.ExamService;
import com.bin.design.drivingschool.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    DssPapersMapper dssPapersMapper;

    @Override
    public void updatePageById(DssPapers dssPapers) {
        dssPapersMapper.updateByPrimaryKeySelective(dssPapers);
    }

    @Override
    public void deletePageById(Integer id) {
        dssPapersMapper.updateStateById(id);
    }

    @Override
    public void deleteBatchPageById(List list) {
        dssPapersMapper.updateBatchStateById(list);
    }

    @Override
    public void insertPage(DssPapers dssPapers) {
        dssPapersMapper.insertSelective(dssPapers);
    }

    @Override
    public PageBean<Map<String, Object>> getPageByType(Integer pageNum,Integer pageSize,Byte type) {
        PageHelper.startPage(pageNum, pageSize);
        if (Objects.isNull(type) || type == 0){
            return new PageBean<>(dssPapersMapper.selectAll());
        }
        return new PageBean<>(dssPapersMapper.selectByType(type));
    }
}
