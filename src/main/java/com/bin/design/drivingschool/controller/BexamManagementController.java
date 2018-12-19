package com.bin.design.drivingschool.controller;


import com.bin.design.drivingschool.entity.DssLeaveWord;
import com.bin.design.drivingschool.entity.DssPapers;
import com.bin.design.drivingschool.service.ExamService;
import com.bin.design.drivingschool.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/back")
@RestController
public class BexamManagementController {

    @Autowired
    ExamService examService;

    @GetMapping("exams")
    public ResponseEntity<PageBean<Map<String, Object>>> getExams(@RequestParam(value = "pageNum") int pageNum,
                                                     @RequestParam(value = "pageSize") int pageSize,
                                                     @RequestParam(value = "type", required = false) Byte type){
        PageBean<Map<String, Object>> exams = examService.getPageByType(pageNum, pageSize, type);
        return new ResponseEntity<>(exams, HttpStatus.OK);

    }

    @PostMapping("exams")
    public ResponseEntity<Object> insertExam(@RequestBody DssPapers dssPapers){
        examService.insertPage(dssPapers);
        return new ResponseEntity<>("题目增加成功", HttpStatus.OK);
    }

    @PutMapping("exams")
    public ResponseEntity<Object> updateExam(@RequestBody DssPapers dssPapers){
        examService.updatePageById(dssPapers);
        return new ResponseEntity<>("题目修改成功", HttpStatus.OK);
    }

    @GetMapping("examsState")
    public ResponseEntity<Object> deleteExam(@RequestParam("id") int id){
        examService.deletePageById(id);
        return new ResponseEntity<>("题目删除成功", HttpStatus.OK);
    }
    @GetMapping("batchExamsState")
    public ResponseEntity<Object> deleteExams(@RequestParam("id") List id){
        examService.deleteBatchPageById(id);
        return new ResponseEntity<>("题目删除成功", HttpStatus.OK);
    }

}
