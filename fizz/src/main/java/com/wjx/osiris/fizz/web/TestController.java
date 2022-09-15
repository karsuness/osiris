package com.wjx.osiris.fizz.web;

import com.wjx.osiris.fizz.domain.Result;
import com.wjx.osiris.fizz.feign.DamoclesFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjinxin
 * @date 2022/9/14 21:01
 * @mail wangjinxin03@corp.netease.com
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private DamoclesFeignService damoclesFeignService;

    @GetMapping("/test")
    public Result test() {
        Result user = damoclesFeignService.getUser();
        return user;
    }
}
