package com.wjx.osiris.hecarim.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.wjx.osiris.hecarim.dto.ExcelErrorResultDTO;
import com.wjx.osiris.hecarim.dto.Result;
import com.wjx.osiris.hecarim.request.PartTimeTeacherInfoExcelRequest;
import com.wjx.osiris.hecarim.service.EduPartTimeTeacherInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 兼职班主任信息表 前端控制器
 * </p>
 *
 * @author liusha
 * @since 2022-05-13
 */
@RestController
@Slf4j
@RequestMapping("/edu/part-time-teacher")
public class EduPartTimeTeacherInfoController {

    @Autowired
    private EduPartTimeTeacherInfoService eduPartTimeTeacherInfoService;

    @PostMapping("upload")
    public Result upload(@RequestBody MultipartFile file) throws IOException {

        log.info("-----------------");

        List<ExcelErrorResultDTO> failList = new ArrayList<>();

        EasyExcel.read(file.getInputStream(), PartTimeTeacherInfoExcelRequest.class, new PageReadListener<PartTimeTeacherInfoExcelRequest>(dataList -> {
            for (PartTimeTeacherInfoExcelRequest demoData : dataList) {
                //校验并判断是否出错
                ExcelErrorResultDTO excelErrorResultDTO = eduPartTimeTeacherInfoService.handExcelData(demoData);
                failList.add(excelErrorResultDTO);
                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
            }
        })).sheet().doRead();
        return Result.success(failList);
    }
}

