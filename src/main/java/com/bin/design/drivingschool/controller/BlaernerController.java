package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.service.LearnerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */

@RequestMapping("/back")
@RestController
public class BlaernerController {

	@Autowired
	LearnerInfoService learnerInfoService;

	@GetMapping("/learners")
	public ResponseEntity<List<DssLearnerInfo>> getAllInfo(){
		List<DssLearnerInfo> dssLearnerInfos = learnerInfoService.selectAllLearner();
		return new ResponseEntity<>(dssLearnerInfos, HttpStatus.OK);
	}

}
