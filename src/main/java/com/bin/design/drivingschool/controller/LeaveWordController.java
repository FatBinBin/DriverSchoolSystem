package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssLeaveWord;
import com.bin.design.drivingschool.service.LeaveWordService;
import com.bin.design.drivingschool.util.SensitivewordFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RequestMapping("/leaveWord")
@RestController
@Slf4j
public class LeaveWordController {

    @Autowired
    LeaveWordService leaveWordService;

    @PostMapping("")
    public ResponseEntity<Object> insertLeave(@RequestBody DssLeaveWord dssLeaveWord) {
        SensitivewordFilter filter = new SensitivewordFilter();

        String string = dssLeaveWord.getWord();

        Set<String> set = filter.getSensitiveWord(string, 1);
        int n = set.size();
        log.debug("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        Map<String, Object> result = new HashMap<>();
        if (n > 0){
            result.put("status", "0");
            result.put("message", "非法留言");
        }else {
        leaveWordService.insert(dssLeaveWord);
            result.put("status", "1");
            result.put("message", "留言成功");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
