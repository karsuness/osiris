package com.wjx.osiris.morgana.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liusha
 * @date 2022/5/17 11:55
 * @mail liusha@wacai.com
 * @description
 */
@RestController
@RequestMapping("/morgana")
public class HomeController {

    @GetMapping("/home")
    @SentinelResource("home")
    public String home() {
        return "home";
    }
}
