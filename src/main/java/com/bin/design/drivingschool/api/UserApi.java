package com.bin.design.drivingschool.api;

import com.alibaba.fastjson.JSONObject;
import com.bin.design.drivingschool.annotation.UserLoginToken;
import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.service.LearnerInfoService;
import com.bin.design.drivingschool.service.impl.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jinbin
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("api")
public class UserApi {
    @Autowired
    LearnerInfoService learnerInfoService;
    @Autowired
    TokenService tokenService;
    //登录
    @PostMapping("/login")
    public Object login(@RequestBody DssLearnerInfo learner){
        JSONObject jsonObject=new JSONObject();
        DssLearnerInfo userForBase = learnerInfoService.selectByLearnerPhone(learner);
//        User userForBase=userService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getLearnerPassword().equals(learner.getLearnerPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}