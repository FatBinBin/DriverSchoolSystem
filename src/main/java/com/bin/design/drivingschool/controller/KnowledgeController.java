package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssDrivingKnowledge;
import com.bin.design.drivingschool.entity.DssKnowledgeComment;
import com.bin.design.drivingschool.entity.DssKnowledgeReply;
import com.bin.design.drivingschool.service.KnowledgeService;
import com.bin.design.drivingschool.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
		PageBean<Map<String,Object>> dssKnowledge = knowledgeService.selectKnowledge(pageNum,pageSize,key);
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

	@GetMapping("/comment")
	public ResponseEntity<PageBean<Map<String,Object>>> getComment(@RequestParam(value = "pageNum") int pageNum,
																   @RequestParam(value = "pageSize") int pageSize,
																   @RequestParam(value = "id")  int id){
		PageBean<Map<String,Object>> comment = knowledgeService.selectComment(pageNum,pageSize,id);
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}

	@PostMapping("/comment")
	public ResponseEntity<Object> addComment(@RequestBody DssKnowledgeComment dssKnowledgeComment){
		Map<String, Object> result = new HashMap<>();
		int count = knowledgeService.insertComment(dssKnowledgeComment);
		if (count > 0){
			result.put("message", "提交成功");
			result.put("status", "1");
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		result.put("message", "提交失败");
		result.put("status", "0");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping("/comment/status")
	public ResponseEntity<Object> updateStatus(@RequestBody DssKnowledgeComment dssKnowledgeComment){
		Map<String, Object> result = new HashMap<>();
		int count = knowledgeService.updateCommentStatus(dssKnowledgeComment);
		if (count > 0){
			result.put("message", "更新成功");
			result.put("status", "1");
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		result.put("message", "更新失败");
		result.put("status", "0");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/reply")
	public ResponseEntity<Object> reply(@RequestBody DssKnowledgeReply dssKnowledgeReply){
		Map<String, Object> result = new HashMap<>();
		int count = knowledgeService.insertReply(dssKnowledgeReply);
		if (count > 0){
			result.put("message", "回复成功");
			result.put("status", "1");
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		result.put("message", "提交失败");
		result.put("status", "0");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


}
