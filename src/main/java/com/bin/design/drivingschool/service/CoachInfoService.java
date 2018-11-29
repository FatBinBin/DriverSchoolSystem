package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssCoachInfo;

import java.util.List;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */
public interface CoachInfoService {

	List<DssCoachInfo> selectCoaches();

	DssCoachInfo selectCoachById(int id);
}
