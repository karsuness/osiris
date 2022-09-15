package com.wjx.osiris.fizz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangjinxin
 * @date 2022/9/14 20:27
 * @mail wangjinxin03@corp.netease.com
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FizzApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzApplication.class, args);
    }
}
