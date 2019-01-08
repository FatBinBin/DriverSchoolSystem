package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssDrivingKnowledge;
import com.bin.design.drivingschool.service.KnowledgeService;
import com.bin.design.drivingschool.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<PageBean<Map<String,Object>>> getKnowledges(@RequestParam(value = "pageNum") int pageNum,
																   @RequestParam(value = "pageSize") int pageSize,
																   @RequestParam(required = false,value = "key")
																		   String key){
		PageBean<Map<String,Object>> dssKnowledge = knowledgeService.selectCoaches(pageNum,pageSize,key);
		return new ResponseEntity<>(dssKnowledge, HttpStatus.OK);
	}

	@GetMapping("/detail")
	public ResponseEntity<Object> getKnowledge(@RequestParam("id") int id) {
		DssDrivingKnowledge dssDrivingKnowledge = knowledgeService.selectById(id);
		return new ResponseEntity<>(dssDrivingKnowledge, HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<Object> updateKnowledge(@RequestBody DssDrivingKnowledge dssDrivingKnowledge) {
		knowledgeService.update(dssDrivingKnowledge);
		return new ResponseEntity<>("更新成功", HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Object> insertKnowledge(@RequestBody DssDrivingKnowledge dssDrivingKnowledge) {
		knowledgeService.insert(dssDrivingKnowledge);
		return new ResponseEntity<>("新增成功", HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<Object> deleteKnowledge(@RequestParam("id") int id) {
		knowledgeService.delete(id);
		return new ResponseEntity<>("删除成功", HttpStatus.OK);
	}

}
