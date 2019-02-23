package com.bin.design.drivingschool.controller;

import com.bin.design.drivingschool.entity.DssPapers;
import com.bin.design.drivingschool.mapper.DssPapersMapper;
import com.bin.design.drivingschool.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/excel")
@Slf4j
@Transactional
public class ExcelController {

    @Autowired
    DssPapersMapper dssPapersMapper;

    @GetMapping("")
    public void downloadExcel(HttpServletResponse response,HttpServletRequest request) {
        try {
            //获取文件的路径
            //String excelPath = request.getSession().getServletContext().getRealPath("/template/"+"excel.xlsx");
            String excelPath = getClass().getResource("/template/" + "excel.xls").getPath();
            if(StringUtils.isEmpty(excelPath)){
                return;
            }
            //String fileName = "excel.xlsx".toString(); // 文件的默认保存名
            // 读到流中
            InputStream inStream = new FileInputStream(excelPath);//文件的存放路径
            // 设置输出的格式
            response.reset();
            response.setContentType("bin");
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode("example.xlsx", "UTF-8"));
            // 循环取出流中的数据
            byte[] b = new byte[200];
            int len;

            while ((len = inStream.read(b)) > 0){
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("")
    public Map<String, Object> importData(@RequestParam MultipartFile file)
    {
        Map<String, Object> result = new HashMap<>();
        Workbook wb = null;
        List<DssPapers> dssPapersList = new ArrayList<>();
        try
        {
//            if (ExcelUtil.isExcel2007(file.getOriginalFilename())) {
//                wb = new XSSFWorkbook(file.getInputStream());
//            } else {
//                wb = new HSSFWorkbook(file.getInputStream());
//            }
            wb = new XSSFWorkbook(file.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
            result.put("status", 0);
            result.put("message","文件错误");
            return result;
        }
        try
        {
            Sheet sheet = wb.getSheetAt(0);//获取第一张表
            for (int i = 1; i <= sheet.getLastRowNum(); i++)
            {
                Row row = sheet.getRow(i);//获取索引为i的行，以0开始
                String question= row.getCell(0).getStringCellValue();//获取第i行的索引为0的单元格数据
                String a = row.getCell(1).getStringCellValue();
                String b = row.getCell(2).getStringCellValue();
                String c = row.getCell(3).getStringCellValue();
                String d = row.getCell(4).getStringCellValue();
                String answer = row.getCell(5).getStringCellValue();
                double type = row.getCell(6).getNumericCellValue();
//                if (StringUtils.isEmpty(question) || StringUtils.isEmpty(a) || StringUtils.isEmpty(b) || StringUtils.isEmpty(c)
//                        && StringUtils.isEmpty(d) || StringUtils.isEmpty(answer) )
//                {
//                    break;
//                }
                DssPapers dssPapers=new DssPapers();
                dssPapers.setQuestion(question);
                dssPapers.setA(a);
                dssPapers.setB(b);
                dssPapers.setC(c);
                dssPapers.setD(d);
                dssPapers.setAnswer(answer);
                dssPapers.setType((byte)type);
                dssPapers.setState((byte)1);
                dssPapersList.add(dssPapers);
            }
            dssPapersMapper.insertBatch(dssPapersList);
        }
        catch (NullPointerException e)
        {
//            e.printStackTrace();
            result.put("status", 0);
            result.put("message","内容格式错误");
            return result;
        }catch (Exception e){
            result.put("status", 0);
            result.put("message","文件类型错误");
            return result;
        }
        for (DssPapers dssPapers : dssPapersList){
            System.out.println(dssPapers.getA() + " " + dssPapers.getB() + " " + dssPapers.getC()
            + " " + dssPapers.getD() + " " + dssPapers.getQuestion() + " " + dssPapers.getAnswer());
        }
        result.put("status", 1);
        result.put("message","批量导入成功");
        return result;
    }





}
