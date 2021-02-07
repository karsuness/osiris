package com.wjx.darius;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liusha
 * @date 2021/2/7 15:29
 * @mail liusha@wacai.com
 * @description 启动类
 */
@SpringBootApplication
@MapperScan("com.wjx.darius.mapper")
public class DariusApplication {
    public static void main(String[] args) {
        SpringApplication.run(DariusApplication.class, args);
    }
}
