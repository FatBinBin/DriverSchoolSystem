package com.bin.design.drivingschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "begin")
    public ResponseEntity<Object> test() {
        String ok = "Ok";
        log.debug("666, {}","666");
        return new ResponseEntity<>(ok, HttpStatus.OK);
    }
}
