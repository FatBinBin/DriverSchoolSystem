package com.bin.design.drivingschool.controller;


import com.bin.design.drivingschool.entity.DssAppointmentDriving;
import com.bin.design.drivingschool.service.AppointmentDrivingService;
import com.bin.design.drivingschool.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/back")
@RestController
public class BappointmentManagementController {

    @Autowired
    AppointmentDrivingService appointmentDrivingService;

    @GetMapping("/appointment")
    public ResponseEntity<PageBean<Map<String,Object>>> getAppointment(@RequestParam(value = "pageNum") int pageNum,
                                                                       @RequestParam(value = "pageSize") int pageSize,
                                                                       @RequestParam(value = "key",required = false)
                                                                               String key){
        PageBean<Map<String,Object>> leaveWords  = appointmentDrivingService.getAll(pageNum,pageSize,key);
        return new ResponseEntity<>(leaveWords, HttpStatus.OK);
    }

    @PutMapping("/appointment")
    public ResponseEntity<Object> updateAppointment(@RequestBody DssAppointmentDriving dssAppointmentDriving) {
        appointmentDrivingService.updateAppointment(dssAppointmentDriving);
        return new ResponseEntity<>("处理成功", HttpStatus.OK);
    }

    @DeleteMapping("/appointment")
    public ResponseEntity<Object> deleteAppointment(@RequestParam("id") int id) {
        appointmentDrivingService.deleteById(id);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }

    @DeleteMapping("/batchAppointment")
    public ResponseEntity<Object> deleteAppointments(@RequestParam("id") List list) {
        appointmentDrivingService.deleteBatchById(list);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }


}
