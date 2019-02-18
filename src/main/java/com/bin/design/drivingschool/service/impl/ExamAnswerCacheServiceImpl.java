package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssExamAnswerCache;
import com.bin.design.drivingschool.mapper.DssExamAnswerCacheMapper;
import com.bin.design.drivingschool.service.ExamAnswerCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamAnswerCacheServiceImpl implements ExamAnswerCacheService {

    @Autowired
    DssExamAnswerCacheMapper dssExamAnswerCacheMapper;

    @Override
    public int add(DssExamAnswerCache dssExamAnswerCache) {
       return dssExamAnswerCacheMapper.insertSelective(dssExamAnswerCache);
    }

    @Override
    public int truncateCache() {
        return dssExamAnswerCacheMapper.truncateTable();
    }

    @Override
    public DssExamAnswerCache getByPaperId(int paperId) {
        return dssExamAnswerCacheMapper.selectByPaperId(paperId);
    }
}
