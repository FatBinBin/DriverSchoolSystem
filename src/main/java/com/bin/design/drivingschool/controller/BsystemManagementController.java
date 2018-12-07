package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssLeaveWord;
import com.bin.design.drivingschool.service.AppointmentDrivingService;
import com.bin.design.drivingschool.service.LeaveWordService;
import com.bin.design.drivingschool.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
	@Autowired
    AppointmentDrivingService appointmentDrivingService;

	@GetMapping("/words")
	public ResponseEntity<PageBean<Map<String,Object>>> getAllWords(@RequestParam(value = "pageNum") int pageNum,
																   @RequestParam(value = "pageSize") int pageSize,
																   @RequestParam(value = "key",required = false)
																			   String key){
		PageBean<Map<String,Object>> leaveWords  = leaveWordService.getAll(pageNum,pageSize,key);
		return new ResponseEntity<>(leaveWords, HttpStatus.OK);
	}

	@DeleteMapping("/words")
	public ResponseEntity<Object> deleteWord(@RequestParam("id") int id){
		leaveWordService.deleteById(id);
		return new ResponseEntity<>("删除成功", HttpStatus.OK);
	}

	@PutMapping("/words")
	public ResponseEntity<Object> updateWord(@RequestBody DssLeaveWord dssLeaveWord){
		leaveWordService.updateWords(dssLeaveWord);
		return new ResponseEntity<>("处理成功", HttpStatus.OK);
	}

	@DeleteMapping("/batchWords")
	public ResponseEntity<Object> deleteWords(@RequestParam("id") List list) {
		leaveWordService.deleteBatchById(list);
		return new ResponseEntity<>("删除成功", HttpStatus.OK);
	}
}
