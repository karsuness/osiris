package com.wjx.osiris.zed;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangjinxin
 * @date 2021/3/19 20:26
 * @mail wjxScott@163.com
 * @description 监控中心启动类
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
@Configuration
public class ZedApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZedApplication.class, args);
    }
}
