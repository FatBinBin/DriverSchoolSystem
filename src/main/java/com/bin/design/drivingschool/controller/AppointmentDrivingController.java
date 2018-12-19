package com.bin.design.drivingschool.controller;


import com.bin.design.drivingschool.entity.DssAppointmentDriving;
import com.bin.design.drivingschool.service.AppointmentDrivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/appointment")
@RestController
public class AppointmentDrivingController {

    @Autowired
    AppointmentDrivingService appointmentDrivingService;

    @PostMapping("/driving")
    public ResponseEntity<Object> insertAppointment(@RequestBody DssAppointmentDriving dssAppointmentDriving) {
        appointmentDrivingService.insert(dssAppointmentDriving);
        return new ResponseEntity<>("留言成功", HttpStatus.OK);
    }
}
