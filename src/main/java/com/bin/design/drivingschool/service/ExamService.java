package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssPapers;
import com.bin.design.drivingschool.util.PageBean;

import java.util.List;
import java.util.Map;

public interface ExamService {

    void insertPage(DssPapers dssPapers);

    PageBean<Map<String, Object>> getPageByType(Integer pageNum,Integer pageSize,Byte type);

    void updatePageById(DssPapers dssPapers);

    void deletePageById(Integer id);

    void deleteBatchPageById(List list);


}
