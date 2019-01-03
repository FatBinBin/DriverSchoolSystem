package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.service.KnowledgeService;
import com.bin.design.drivingschool.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author huangyubin
 * @version 2019/1/3
 * @since
 */

@RestController
@RequestMapping("/knowledge")
@Slf4j
public class KnowledgeController {

	@Autowired
	KnowledgeService knowledgeService;

	@GetMapping("")
	public ResponseEntity<PageBean<Map<String,Object>>> getCoaches(@RequestParam(value = "pageNum") int pageNum,
																   @RequestParam(value = "pageSize") int pageSize,
																   @RequestParam(required = false,value = "key")
																		   String key){
		PageBean<Map<String,Object>> dssKnowledge = knowledgeService.selectCoaches(pageNum,pageSize,key);
		return new ResponseEntity<>(dssKnowledge, HttpStatus.OK);
	}

}
