package com.wjx.osiris.jayce.controller;

import com.wjx.osiris.jayce.entity.UserInfo;
import com.wjx.osiris.jayce.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangjinxin
 * @since 2022-09-25
 */
@RestController
@RequestMapping("/jayce/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/insert")
    public void insert(@RequestBody UserInfo userInfo) {
        userInfoService.insert(userInfo);
    }

    @PostMapping("/get")
    public UserInfo get(@RequestBody UserInfo userInfo) {
        return userInfoService.getUserInfo(userInfo);
    }

}
