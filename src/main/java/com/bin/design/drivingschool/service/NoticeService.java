package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssNotice;
import com.bin.design.drivingschool.util.PageBean;

import java.util.List;
import java.util.Map;

public interface NoticeService {

    PageBean<Map<String,Object>> getAll(Integer pageNum, Integer pageSize , String key);

    void insert(DssNotice dssNotice);

    void update(DssNotice dssNotice);

    void delete(Integer id);

    void batchDelete(List id);

}
