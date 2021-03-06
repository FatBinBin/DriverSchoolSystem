package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssCoachInfo;
import com.bin.design.drivingschool.service.CoachInfoService;
import com.bin.design.drivingschool.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author huangyubin
 * @version 2018/11/29
 * @since
 */
@RestController
@RequestMapping("/coaches")
@Slf4j
public class CoachController {

	@Autowired
	CoachInfoService coachInfoService;

	@GetMapping("")
	public ResponseEntity<PageBean<Map<String,Object>>> getCoaches(@RequestParam(value = "pageNum") int pageNum,
																   @RequestParam(value = "pageSize") int pageSize,
																   @RequestParam(required = false,value = "key")
																		   String key){
		PageBean<Map<String,Object>> dssCoachInfos = coachInfoService.selectCoaches(pageNum,pageSize,key);
		return new ResponseEntity<>(dssCoachInfos, HttpStatus.OK);
	}

	@GetMapping("/info")
	public ResponseEntity<Object> getCoach(@RequestParam("id") int id){
		Map<String, Object> dssCoachInfo = coachInfoService.selectCoachById(id);
		return new ResponseEntity<>(dssCoachInfo, HttpStatus.OK);
	}

	@GetMapping("/idAndName")
	public ResponseEntity<List<Map<String, Object>>> getCoachIdAndName(){
		List<Map<String, Object>> dssCoachInfo = coachInfoService.selectCoachIdAndName();
		return new ResponseEntity<>(dssCoachInfo, HttpStatus.OK);
	}

	@GetMapping("/form")
	public ResponseEntity<PageBean<Map<String,Object>>> getform(@RequestParam(value = "pageNum") int pageNum,
																   @RequestParam(value = "pageSize") int pageSize,
																@RequestParam(value = "season") int season
																   ){
		PageBean<Map<String,Object>> dssCoachForm = coachInfoService.getCoachForm(pageNum,pageSize, season);
		return new ResponseEntity<>(dssCoachForm, HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Object> countLearner(){
		List<Map<String, Object>> dssCoachInfo = coachInfoService.countLearnerNum();
		return new ResponseEntity<>(dssCoachInfo, HttpStatus.OK);
	}

}
