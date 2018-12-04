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
import java.util.Map;

@RestController
@RequestMapping("/back")
@Slf4j
public class BcoachController {

    @Autowired
    CoachInfoService coachInfoService;

    @GetMapping("/coaches")
    public ResponseEntity<PageBean<Map<String,Object>>> getCoaches(@RequestParam(value = "pageNum") int pageNum,
                                                                   @RequestParam(value = "pageSize") int pageSize){
        PageBean<Map<String,Object>> dssCoachInfos = coachInfoService.selectCoaches(pageNum,pageSize);
        return new ResponseEntity<>(dssCoachInfos, HttpStatus.OK);
    }
}
