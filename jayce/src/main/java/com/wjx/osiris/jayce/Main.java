package com.wjx.osiris.jayce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangjinxin
 * @date 2022/9/25 13:04
 * @mail wangjinxin03@corp.netease.com
 * @description
 */
@SpringBootApplication
@MapperScan("com.wjx.osiris.jayce.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
