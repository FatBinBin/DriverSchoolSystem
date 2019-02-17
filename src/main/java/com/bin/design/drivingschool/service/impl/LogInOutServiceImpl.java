package com.bin.design.drivingschool.service.impl;

import com.bin.design.drivingschool.constant.LogInStatus;
import com.bin.design.drivingschool.constant.LogInTypeStatus;
import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.mapper.DssLearnerInfoMapper;
import com.bin.design.drivingschool.service.LearnerInfoService;
import com.bin.design.drivingschool.service.LogInOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service("logInOutService")
@Slf4j
public class LogInOutServiceImpl implements LogInOutService {

    @Autowired
    LearnerInfoService learnerInfoService;
    @Autowired
    DssLearnerInfoMapper dssLearnerInfoMapper;

    //key值为用户信息组合键
    private static Map<String, HttpSession> sessionMap = new HashMap<>();
    //key值为sessionId
    private static Map<String, String> userMap = new HashMap<>();

    /**
     * 检验登陆状态
     *
     * @param httpSession
     * @return
     */
    @Override
    public Map<String, Object> checkLogInStatus(HttpSession httpSession) {
        Map<String, Object> result = new HashMap<>();
        if (httpSession.getAttribute("isUser") != null) {
            result.put("status", LogInStatus.user.getCode());//用户
            result.put("userPk", httpSession.getAttribute("UserPK").toString());
        } else {
            result.put("status", LogInStatus.visitor.getCode());
        }
        return result;
    }

    /**
     * 用户登陆
     *
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> login(Map<String, Object> param, HttpSession httpSession) {
        Map<String, Object> result = new HashMap<>();
        //用户验证
        DssLearnerInfo userForBase = learnerInfoService.selectLearnerByIdcar(param.get("learnerIdcar").toString());
        if (userForBase != null && userForBase.getLearnerPassword().equals(param.get("learnerPassword").toString())) {
            String message = userForBase.getLearnerPhone()+userForBase.getLearnerName();
            int loginType = validateLogin(httpSession, message);
            if (loginType == LogInTypeStatus.sameBrowserRepeatLogin.getCode()) {
                result.put("isCorrect", false);
                result.put("reLogin", true);
            } else if (loginType == LogInTypeStatus.differentBrowserRepeatLogin.getCode()) {
                result.put("isCorrect", true);
                result.put("UserPK", userForBase.getId());
                result.put("SignIn_IsAdmin", false);
                result.put("reLogin", true);
            } else {
                result.put("isCorrect", true);
                result.put("UserPK", userForBase.getId());
                result.put("SignIn_IsAdmin", false);
                result.put("reLogin", false);
            }
        } else {
            result.put("isCorrect", false);
            // 是否是重复登陆
            result.put("reLogin", false);
        }
    // 把登录信息放进session中
        if((boolean)result.get("isCorrect"))
    {
        httpSession.setAttribute("isUser", param.get("isUser"));
        httpSession.setAttribute("UserPK", result.get("UserPK"));
    }
        return result;
}

    /**
     * 重复登陆验证
     *
     * @param httpSession
     * @param message
     * @return
     */
    private int validateLogin(HttpSession httpSession, String message) {
        int result = 2;
        //先判断登陆时用户是否已经登陆
        if (sessionMap.containsKey(message)) {
            HttpSession oldSession = sessionMap.remove(message);
            //再判断session是否已存在，已存在说明是同一个浏览器登陆的
            if (userMap.containsValue(oldSession.getId())) {
                //同一个浏览器登陆
                userMap.remove(oldSession.getId());
                sessionMap.put(message, httpSession);
                userMap.put(httpSession.getId(), message);
                result = LogInTypeStatus.sameBrowserRepeatLogin.getCode();
            } else {
                //踢掉旧用户session
                oldSession.invalidate();
                sessionMap.put(message, httpSession);
                userMap.put(httpSession.getId(), message);
                result = LogInTypeStatus.differentBrowserRepeatLogin.getCode();
            }
        } else {
            //正常登陆
            sessionMap.put(message, httpSession);
            userMap.put(httpSession.getId(), message);
            result = LogInTypeStatus.normalLogin.getCode();
        }
        return result;
    }

    @Override
    public Map<String, Object> getUser(Integer id) {
        return dssLearnerInfoMapper.selectInfoByPrimaryKey(id);
    }

    /**
     * 用户登出
     *
     * @param httpSession
     * @return
     */
    @Override
    public Map<String, Object> logout(HttpSession httpSession) {
        Map<String, Object> reslut = new HashMap<>();
        if (httpSession.getAttribute("isUser") != null) {
                httpSession.removeAttribute("UserPK");
        }
        httpSession.removeAttribute("isUser");
        sessionMap.remove(userMap.remove(httpSession.getId()));
        reslut.put("status", 1);
        return reslut;
    }
}
