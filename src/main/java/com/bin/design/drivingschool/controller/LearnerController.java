package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssEvaluate;
import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.service.EvaluateService;
import com.bin.design.drivingschool.service.LearnerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */

@RestController
@RequestMapping("/learner")
@Slf4j
public class LearnerController {

	@Autowired
	private LearnerInfoService learnerInfoService;
	@Autowired
	private EvaluateService evaluateService;

	@GetMapping("/info")
	public ResponseEntity<DssLearnerInfo> getInfo(@RequestParam("id") int id){
		DssLearnerInfo dssLearnerInfo = learnerInfoService.selectById(id);
		return new ResponseEntity<>(dssLearnerInfo, HttpStatus.OK);
	}

	@PutMapping("/info")
	public ResponseEntity<Object> updateInfo(@RequestBody DssLearnerInfo dssLearnerInfo){
		learnerInfoService.updateById(dssLearnerInfo);
		return new ResponseEntity<>("更新成功",HttpStatus.OK);
	}

	@GetMapping("/examinationProcessed")
	public ResponseEntity<Map<String, Object>> getProcessed(@RequestParam("id") int id){
		Map<String, Object> processed = learnerInfoService.selectProcessedById(id);
		return new ResponseEntity<>(processed,HttpStatus.OK);
	}


}
