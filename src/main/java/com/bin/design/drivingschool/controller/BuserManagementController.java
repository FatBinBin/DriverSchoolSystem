package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssCoachInfo;
import com.bin.design.drivingschool.entity.DssLearnerInfo;
import com.bin.design.drivingschool.service.CoachInfoService;
import com.bin.design.drivingschool.service.LearnerInfoService;
import com.bin.design.drivingschool.util.FileUtil;
import com.bin.design.drivingschool.util.MD5Utils;
import com.bin.design.drivingschool.util.PageBean;
import com.bin.design.drivingschool.util.PwdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author huangyubin
 * @version 2018/12/5
 * @since
 */

@RequestMapping("/back")
@RestController
@Slf4j
public class BuserManagementController {

    @Autowired
    LearnerInfoService learnerInfoService;
    @Autowired
    CoachInfoService coachInfoService;

    @GetMapping("/learners")
    public ResponseEntity<PageBean<Map<String, Object>>> getAllInfo(@RequestParam(value = "pageNum") int pageNum,
                                                                    @RequestParam(value = "pageSize") int pageSize,
                                                                    @RequestParam(required = false, value = "key")
                                                                            String key) {
        PageBean<Map<String, Object>> dssLearnerInfos = learnerInfoService.selectAllLearner(pageNum, pageSize, key);
        return new ResponseEntity<>(dssLearnerInfos, HttpStatus.OK);
    }

    @PutMapping("/learners")
    public ResponseEntity<Object> updateLearner(@RequestBody DssLearnerInfo dssLearnerInfo) {
        learnerInfoService.updateById(dssLearnerInfo);
        return new ResponseEntity<>("更新成功", HttpStatus.OK);
    }

    @PostMapping("/learners")
    public ResponseEntity<Object> insertLearner(@RequestBody DssLearnerInfo dssLearnerInfo) {
        DssLearnerInfo check = learnerInfoService.selectLearnerByPhone(dssLearnerInfo.getLearnerPhone());
        if (check != null){
            return new ResponseEntity<>("该手机已注册报名", HttpStatus.OK);
        }
        String password = PwdUtil.getPassword();
        log.debug("生成的密码为" + password);
        String encode = MD5Utils.MD5Encode(password, "UTF-8");
        log.debug("MD5加密: " + encode);
        log.debug("认证: " + encode.equals(MD5Utils.MD5Encode(password, "UTF-8")));
        dssLearnerInfo.setLearnerPassword(password);
        learnerInfoService.insert(dssLearnerInfo);
        return new ResponseEntity<>("新增成功,密码为：" + password, HttpStatus.OK);
    }


    @DeleteMapping("/learners")
    public ResponseEntity<Object> deleteLearner(@RequestParam("id") int id) {
        learnerInfoService.deleteById(id);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }

    @DeleteMapping("/batchLearners")
    public ResponseEntity<Object> deleteLearners(@RequestParam("id") List list) {
        learnerInfoService.deleteBatchById(list);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }

    @GetMapping("/coaches")
    public ResponseEntity<PageBean<Map<String, Object>>> getCoaches(@RequestParam(value = "pageNum") int pageNum,
                                                                    @RequestParam(value = "pageSize") int pageSize,
                                                                    @RequestParam(required = false, value = "key")
                                                                            String key) {
        PageBean<Map<String, Object>> dssCoachInfos = coachInfoService.selectCoaches(pageNum, pageSize, key);
        return new ResponseEntity<>(dssCoachInfos, HttpStatus.OK);
    }

    @PutMapping("/coaches")
    public ResponseEntity<Object> updateCoach(@RequestBody DssCoachInfo dssCoachInfo) {
        coachInfoService.updateById(dssCoachInfo);
        return new ResponseEntity<>("更新成功", HttpStatus.OK);
    }

    @PostMapping("/coaches")
    public ResponseEntity<Object> insertCoach(@RequestBody DssCoachInfo dssCoachInfo) {
        coachInfoService.insert(dssCoachInfo);
        return new ResponseEntity<>("新增成功", HttpStatus.OK);
    }


    @DeleteMapping("/coaches")
    public ResponseEntity<Object> deleteCoach(@RequestParam("id") int id) {
        coachInfoService.deleteById(id);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }

    @DeleteMapping("/batchCoaches")
    public ResponseEntity<Object> deleteCoaches(@RequestParam("id") List list) {
        coachInfoService.deleteBatchById(list);
        return new ResponseEntity<>("删除成功", HttpStatus.OK);
    }

    @GetMapping("/learnerForCoaches")
    public ResponseEntity<PageBean<Map<String, Object>>> getLearnerForCoach(@RequestParam(value = "pageNum") int pageNum,
                                                                    @RequestParam(value = "pageSize") int pageSize,
                                                                    @RequestParam(value = "id")int id) {
        PageBean<Map<String, Object>> dssCoachInfos = coachInfoService.selectLearnerForCoach(pageNum, pageSize, id);
        return new ResponseEntity<>(dssCoachInfos, HttpStatus.OK);
    }

    @PostMapping("/img")
    public ResponseEntity<Object> uploaImg(@RequestParam(value = "file") MultipartFile file) {
        String contentType = file.getContentType();
        String filePath = "D:\\IdeaProject\\coachImg\\";
        String fileName = file.getOriginalFilename();
//		log.debug("fileName--> {}, getContentType--> {}, uploadPath--> {}" ,fileName, contentType);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(filePath+fileName, HttpStatus.OK);
    }

}
