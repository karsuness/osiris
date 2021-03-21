package com.wjx.osiris.jhin.controller;


import com.wjx.osiris.jhin.service.UserInfoService;
import com.wjx.qilin.annotation.LogAnnotation;
import com.wjx.qilin.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjinxin
 * @date 2021/3/21 21:11
 * @mail wjxScott@163.com
 * @description UserInfoController
 */
@RestController
@RequestMapping("/user-info")
@Slf4j
@LogAnnotation
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/list")
    public Result listUserInfo() {
        return Result.success(userInfoService.listUserInfo());
    }

}

