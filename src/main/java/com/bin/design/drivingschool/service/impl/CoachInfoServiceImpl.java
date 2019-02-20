package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.entity.DssCoachInfo;
import com.bin.design.drivingschool.mapper.DssCoachInfoMapper;
import com.bin.design.drivingschool.mapper.DssLearnerInfoMapper;
import com.bin.design.drivingschool.service.CoachInfoService;
import com.bin.design.drivingschool.util.PageBean;
import com.bin.design.drivingschool.util.SeasonUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */
@Service
public class CoachInfoServiceImpl implements CoachInfoService {

    @Autowired
    DssCoachInfoMapper dssCoachInfoMapper;
    @Autowired
    DssLearnerInfoMapper dssLearnerInfoMapper;

    @Override
    public PageBean<Map<String, Object>> selectCoaches(Integer pageNum, Integer pageSize, String key) {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isEmpty(key)) {
            return new PageBean<>(dssCoachInfoMapper.selectAll());
        }
        return new PageBean<>(dssCoachInfoMapper.selectByKey(key));
    }

    @Override
    public void updateById(DssCoachInfo dssCoachInfo) {
        dssCoachInfoMapper.updateByPrimaryKeySelective(dssCoachInfo);
    }

    @Override
    public void insert(DssCoachInfo dssCoachInfo) {
        dssCoachInfoMapper.insertSelective(dssCoachInfo);
    }

    @Override
    public void deleteById(Integer id) {
        dssCoachInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBean<Map<String, Object>> getCoachForm(Integer pageNum, Integer pageSize, Integer season) {
        PageHelper.startPage(pageNum, pageSize);
        String beginTime = null;
        String endTime = null;
        if (season == 1) {
            beginTime = SeasonUtils.getSeasonCharDate(1, null)[0] + " 00:00:00";
            endTime = SeasonUtils.getSeasonCharDate(1, null)[1] + " 23:59:59";
        } else if (season == 2) {
            beginTime = SeasonUtils.getSeasonCharDate(2, null)[0] + " 00:00:00";
            endTime = SeasonUtils.getSeasonCharDate(2, null)[1] + " 23:59:59";
        } else if (season == 3) {
            beginTime = SeasonUtils.getSeasonCharDate(3, null)[0] + " 00:00:00";
            endTime = SeasonUtils.getSeasonCharDate(3, null)[1] + " 23:59:59";
        } else if (season == 4) {
            beginTime = SeasonUtils.getSeasonCharDate(4, null)[0] + " 00:00:00";
            endTime = SeasonUtils.getSeasonCharDate(4, null)[1] + " 23:59:59";
        } else {
            beginTime = SeasonUtils.getSeasonCharDate(0, null)[0] + " 00:00:00";
            endTime = SeasonUtils.getSeasonCharDate(0, null)[1] + " 23:59:59";
        }
        return new PageBean<>(dssCoachInfoMapper.coachForm(beginTime, endTime));
    }

    @Override
    public void deleteBatchById(List list) {
        dssCoachInfoMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public List<Map<String, Object>> selectCoachIdAndName() {
        return dssCoachInfoMapper.selectIdAndName();
    }

    @Override
    public DssCoachInfo selectCoachById(int id) {
        return dssCoachInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean<Map<String, Object>> selectLearnerForCoach(Integer pageNum, Integer pageSize, Integer id) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(dssLearnerInfoMapper.selectLearnerForCoach(id));
    }
}
