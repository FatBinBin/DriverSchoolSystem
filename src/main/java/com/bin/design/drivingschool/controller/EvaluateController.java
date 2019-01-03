package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssEvaluate;
import com.bin.design.drivingschool.service.EvaluateService;
import com.bin.design.drivingschool.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/evaluated")
@Slf4j
public class EvaluateController {

    @Autowired
    EvaluateService evaluateService;

    @GetMapping("")
    public ResponseEntity<PageBean<Map<String, Object>>> getAllInfo(@RequestParam(value = "pageNum") int pageNum,
                                                                    @RequestParam(value = "pageSize") int pageSize,
                                                                    @RequestParam(value = "coachId", required = false)
                                                                                Integer coachId,
                                                                    @RequestParam(value = "key", required = false)
                                                                                String key) {
        PageBean<Map<String, Object>> dssEvaluate = evaluateService.selectEvalutes(pageNum, pageSize, coachId, key);
        return new ResponseEntity<>(dssEvaluate, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> evaluate(@RequestBody DssEvaluate dssEvaluate){
        evaluateService.insertEvalute(dssEvaluate);
        return new ResponseEntity<>("评价成功", HttpStatus.OK);

    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteCoach(@RequestParam("id") int id) {
        evaluateService.deleteById(id);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Object> deleteCoaches(@RequestParam("id") List list) {
        evaluateService.deleteBatchById(list);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }
}
