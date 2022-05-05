package com.wjx.osiris.hecarim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class HecarimApplication {

    public static void main(String[] args) {
        SpringApplication.run(HecarimApplication.class, args);
    }

}
