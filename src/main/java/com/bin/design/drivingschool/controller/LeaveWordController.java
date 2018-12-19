package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssLeaveWord;
import com.bin.design.drivingschool.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/leaveWord")
@RestController
public class LeaveWordController {

    @Autowired
    LeaveWordService leaveWordService;

    @PostMapping("")
    public ResponseEntity<Object> insertLeave(@RequestBody DssLeaveWord dssLeaveWord) {
        leaveWordService.insert(dssLeaveWord);
        return new ResponseEntity<>("留言成功", HttpStatus.OK);
    }
}
