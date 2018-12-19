package com.bin.design.drivingschool.controller;


import com.bin.design.drivingschool.entity.DssNotice;
import com.bin.design.drivingschool.service.NoticeService;
import com.bin.design.drivingschool.util.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/notice")
@RestController
@Slf4j
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("")
    public ResponseEntity<PageBean<Map<String, Object>>> getAllNotice(@RequestParam(value = "pageNum") int pageNum,
                                                                    @RequestParam(value = "pageSize") int pageSize,
                                                                    @RequestParam(required = false, value = "key")
                                                                            String key) {
        PageBean<Map<String, Object>> dssNotice = noticeService.getAll(pageNum, pageSize, key);
        return new ResponseEntity<>(dssNotice, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> insertNotice(@RequestBody DssNotice dssNotice){
        noticeService.insert(dssNotice);
        return new ResponseEntity<>("公告发布成功", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Object> updateNotice(@RequestBody DssNotice dssNotice){
        noticeService.update(dssNotice);
        return new ResponseEntity<>("公告修改成功", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteNotice(@RequestParam("id") int id){
        noticeService.delete(id);
        return new ResponseEntity<>("公告修删除成功", HttpStatus.OK);
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Object> batchDeleteNotice(@RequestParam("id")List id){
        noticeService.batchDelete(id);
        return new ResponseEntity<>("公告批量修删除成功", HttpStatus.OK);
    }



}
