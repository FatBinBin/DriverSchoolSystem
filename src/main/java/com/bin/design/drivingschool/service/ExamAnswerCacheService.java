package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssExamAnswerCache;

public interface ExamAnswerCacheService {

    int add(DssExamAnswerCache dssExamAnswerCache);

    DssExamAnswerCache getByPaperId(int paperId);

    int truncateCache();

}
