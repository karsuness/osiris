package com.wjx.osiris.hecarim.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liusha
 * @date 2022/5/9 16:59
 * @mail liusha@wacai.com
 * @description
 */
@RestController
@RequestMapping("/hecarim")
public class UserController {

    @GetMapping("/list")
    public String list() {
        return "testxzzz";
    }
}
