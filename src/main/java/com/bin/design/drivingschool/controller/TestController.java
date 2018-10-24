package com.bin.design.drivingschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "begin")
    public String test() {
        return "helloWorld";
    }
}
