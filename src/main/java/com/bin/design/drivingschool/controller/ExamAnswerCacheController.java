package com.bin.design.drivingschool.controller;


import com.bin.design.drivingschool.entity.DssExamAnswerCache;
import com.bin.design.drivingschool.service.ExamAnswerCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/answer")
@Slf4j
public class ExamAnswerCacheController {

    @Autowired
    ExamAnswerCacheService answerCacheService;

    @GetMapping("/cache")
    public ResponseEntity<Object> getCache(@RequestParam(value = "paperId") int paperId){
        Map<String, Object> result = new HashMap<>();
        DssExamAnswerCache dssExamAnswerCache = answerCacheService.getByPaperId(paperId);
        if (dssExamAnswerCache == null){
            result.put("status", 0);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        result.put("status", 1);
        result.put("data", dssExamAnswerCache);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/cache")
    public ResponseEntity<Object> addAnswer(@RequestBody DssExamAnswerCache dssExamAnswerCache){
        Map<String, Object> result = new HashMap<>();
        int check = answerCacheService.add(dssExamAnswerCache);
        if (check > 0){
            result.put("status", 1);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        result.put("status", 0);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/cache")
    public ResponseEntity<Object> deletCache(){
        Map<String, Object> result = new HashMap<>();
        int check = answerCacheService.truncateCache();
        if (check > 0){
            result.put("status", 0);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        result.put("status", 1);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
