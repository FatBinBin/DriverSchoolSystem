package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssEvaluate;
import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.service.EvaluateService;
import com.bin.design.drivingschool.service.LearnerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */

@RestController
@RequestMapping("/learner")
@Slf4j
public class LearnerController {

	private String[] processing = {"0", "1", "2", "3", "4"};

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

	@GetMapping("/allProcessed")
	public ResponseEntity<Map<String, Object>> getAllProcessed(){
		Map<String, Object> result = learnerInfoService.selectAllProsessing();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/season")
	public ResponseEntity<Map<String, Object>> getLearnerBySeason(){
		Map<String, Object> result = learnerInfoService.selectLearnerBySession();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/year")
	public ResponseEntity<Map<String, Object>> getLearnerByYear(){
		Map<String, Object> result = learnerInfoService.selectLearnerByYear();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/title")
	public ResponseEntity<Object> getTitle(@RequestParam(value = "id") int id) {
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> map = learnerInfoService.selectTitleById(id);
		if (map != null) {
			result.put("status", 1);
			result.put("data", map);
		} else {
			result.put("status", 0);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/title")
		public ResponseEntity<Object> title(@RequestBody Map<String, Object> map){
			Map<String, Object> result = new HashMap<>();
			int title = Integer.parseInt(map.get("title").toString());
			int id = Integer.parseInt(map.get("id").toString());
			int count = learnerInfoService.updateTitleById(title, id);
			if (count > 0) {
				result.put("status", 1);
			}else {
				result.put("status", 0);
			}
			return new ResponseEntity<>(result, HttpStatus.OK);
	}


}
