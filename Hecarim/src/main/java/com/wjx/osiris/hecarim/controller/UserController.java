package com.wjx.osiris.hecarim.controller;

import com.wjx.osiris.hecarim.domain.User;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/query")
    public String query(@RequestBody User user) {
        System.out.println(user);
        return "String Post";
    }
}
