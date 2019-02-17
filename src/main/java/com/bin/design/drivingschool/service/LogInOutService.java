package com.bin.design.drivingschool.service;

import com.bin.design.drivingschool.entity.DssLearnerInfo;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface LogInOutService {
    Map<String, Object> checkLogInStatus(HttpSession httpSession);

    Map<String, Object> login(Map<String, Object> param, HttpSession httpSession);

    Map<String, Object> logout(HttpSession httpSession);

    Map<String, Object> getUser(Integer id);


}
