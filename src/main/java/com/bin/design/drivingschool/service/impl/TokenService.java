package com.bin.design.drivingschool.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bin.design.drivingschool.entity.DssLearnerInfo;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public static String getToken(DssLearnerInfo dssLearnerInfo) {
        String token="";
        token= JWT.create().withAudience(dssLearnerInfo.getLearnerPhone())
                .sign(Algorithm.HMAC256(dssLearnerInfo.getLearnerPassword()));
        return token;
    }
}
