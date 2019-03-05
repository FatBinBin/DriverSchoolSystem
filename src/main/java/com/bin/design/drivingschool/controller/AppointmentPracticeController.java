package com.bin.design.drivingschool.controller;


import com.bin.design.drivingschool.entity.DssAppointmentDriving;
import com.bin.design.drivingschool.entity.DssAppointmentPractice;
import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.service.AppointmentPracticeService;
import com.bin.design.drivingschool.service.LearnerInfoService;
import com.bin.design.drivingschool.util.PageBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointment")
@Slf4j
public class AppointmentPracticeController {

    @Autowired
    AppointmentPracticeService appointmentPracticeService;
    @Autowired
    LearnerInfoService learnerInfoService;

    @PostMapping("/practice")
    public ResponseEntity<Object> insertAppointment(@RequestBody DssAppointmentPractice dssAppointmentPractice) {
        Map<String, Object> result = new HashMap<>();
        int count = appointmentPracticeService.insert(dssAppointmentPractice);
        if (count == -1){
            result.put("status",0);
            result.put("message", "你已预约过该该时间");
        }else {
            result.put("status", 1);
            result.put("message", "提交成功");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/practice")
    public ResponseEntity<PageBean<DssAppointmentPractice>> getForm(@RequestParam(value = "pageNum") int pageNum,
                                                                @RequestParam(value = "pageSize") int pageSize,
                                                                @RequestParam(value = "learnerId") int learnerId
    ){
        PageBean<DssAppointmentPractice> dssCoachForm = appointmentPracticeService.selectAppointmentRecord(pageNum,pageSize, learnerId);
        return new ResponseEntity<>(dssCoachForm, HttpStatus.OK);
    }

    @PutMapping("/practice")
    public ResponseEntity<Object> updateAppointment(@RequestBody DssAppointmentPractice dssAppointmentPractice) {
        appointmentPracticeService.updataById(dssAppointmentPractice);
        return new ResponseEntity<>("修改成功", HttpStatus.OK);
    }

    @DeleteMapping("/practice")
    public ResponseEntity<Object> deleteAppointment(@RequestParam("id")int id) {
        appointmentPracticeService.deleteById(id);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }

    @DeleteMapping("/practice/batch")
    public ResponseEntity<Object> deleteCoaches(@RequestParam("id") List list) {
        appointmentPracticeService.deleteBatchById(list);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }


    @GetMapping("/practice/all")
    public ResponseEntity<PageBean<Map<String, Object>>> getAll(@RequestParam(value = "pageNum") int pageNum,
                                                                    @RequestParam(value = "pageSize") int pageSize,
                                                                @RequestParam(value = "key",required = false)String key){
        PageBean<Map<String, Object>> dssCoachForm = appointmentPracticeService.selectAll(pageNum,pageSize,key);
        return new ResponseEntity<>(dssCoachForm, HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<Object> check(@RequestParam("coachId") int coachId,
                                        @RequestParam("appointmentTime") String appointmentTime,
                                        @RequestParam("moment") Byte moment){
        Map<String, Object> result = appointmentPracticeService.checkAppointment(coachId, appointmentTime, moment);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/coach")
    public ResponseEntity<PageBean<Map<String, Object>>> coachAppointment(@RequestParam(value = "pageNum") int pageNum,
                                                                @RequestParam(value = "pageSize") int pageSize,
                                                                          @RequestParam("coachId") int coachId,
                                                                          @RequestParam("appointmentTime") String appointmentTime,
                                                                          @RequestParam("moment") Byte moment){
        PageBean<Map<String, Object>> coachAppointment =
                appointmentPracticeService.selectCoachAppointment(pageNum,pageSize,coachId,appointmentTime,moment);
        return new ResponseEntity<>(coachAppointment, HttpStatus.OK);
    }

    @GetMapping("/checkIdentity")
    public ResponseEntity<Object> checkIdentity(@RequestParam("learnerIdcar") String learnerIdcar){
        Map<String, Object> result = new HashMap<>();
        DssLearnerInfo  dssLearnerInfo =learnerInfoService.selectLearnerByIdcar(learnerIdcar);
        if (dssLearnerInfo != null){
            result.put("status", 1);
            result.put("data", dssLearnerInfo);
        }else {
            result.put("status", 0);
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
