package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.service.LearnerInfoService;
import com.bin.design.drivingschool.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
	public ResponseEntity<PageBean<Map<String,Object>>> getAllInfo( @RequestParam(value = "pageNum") int pageNum,
																	@RequestParam(value = "pageSize") int pageSize){
		PageBean<Map<String,Object>> dssLearnerInfos = learnerInfoService.selectAllLearner(pageNum,pageSize);
		return new ResponseEntity<>(dssLearnerInfos, HttpStatus.OK);
	}

}
