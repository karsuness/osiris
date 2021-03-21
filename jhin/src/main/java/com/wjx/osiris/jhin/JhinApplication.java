package com.wjx.osiris.jhin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangjinxin
 * @date 2021/3/21 21:40
 * @mail wjxScott@163.com
 * @description 启动类
 */
@SpringBootApplication
@MapperScan(" com.wjx.osiris.jhin.mapper")
public class JhinApplication {
    public static void main(String[] args) {
        SpringApplication.run(JhinApplication.class, args);
    }
}
