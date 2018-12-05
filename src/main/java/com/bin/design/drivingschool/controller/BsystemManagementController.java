package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.service.LeaveWordService;
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
 * @version 2018/12/5
 * @since
 */

@RequestMapping("/back")
@RestController
public class BsystemManagementController {

	@Autowired
	LeaveWordService leaveWordService;

	@GetMapping("/words")
	public ResponseEntity<PageBean<Map<String,Object>>> getAllInfo(@RequestParam(value = "pageNum") int pageNum,
																   @RequestParam(value = "pageSize") int pageSize){
		PageBean<Map<String,Object>> leaveWords  = leaveWordService.getAll(pageNum,pageSize);
		return new ResponseEntity<>(leaveWords, HttpStatus.OK);
	}


}
