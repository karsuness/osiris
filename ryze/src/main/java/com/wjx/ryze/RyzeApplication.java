package com.wjx.ryze;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangjinxin
 * @date 2021/1/14 0:52
 * @mail wjxScott@163.com
 * @description 启动类
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class RyzeApplication {
    public static void main(String[] args) {
        SpringApplication.run(RyzeApplication.class, args);
    }
}
