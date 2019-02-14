package com.bin.design.drivingschool.controller;


import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.service.LearnerInfoService;
import com.bin.design.drivingschool.service.LogInOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/user")
@RestController
@Slf4j
public class LoginOutController {

    @Autowired
    LearnerInfoService learnerInfoService;
    @Autowired
    LogInOutService logInOutService;

    @PostMapping(value = "/checkLoginRank")
    public ResponseEntity<Object> checkLoginStatus(HttpSession session) {
        log.debug("判断登录状态,参数:httpSession={}", session.getId());
        Map<String, Object> result = logInOutService.checkLogInStatus(session);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, Object> params, HttpSession httpSession) {
        Map<String, Object> result = logInOutService.login(params, httpSession);
        log.debug("用户登陆,用户信息={}，结果={}", params, result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<Object> logout(HttpSession httpSession) {
        Map<String, Object> result = logInOutService.logout(httpSession);
        log.debug("用户登出,结果={}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/info")
    public ResponseEntity<DssLearnerInfo> info(@RequestParam("id") int id){
        DssLearnerInfo learnerInfo = logInOutService.getUser(id);
        log.debug("用户信息, {}", learnerInfo);
        return new ResponseEntity<>(learnerInfo, HttpStatus.OK);
    }
}
