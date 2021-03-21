package com.wjx.osiris.yorick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author wangjinxin
 * @date 2021/3/21 13:32
 * @mail wjxScott@163.com
 * @description 配置中心启动类
 */
@SpringBootApplication
@EnableConfigServer
public class YorickApplication {
    public static void main(String[] args) {
        SpringApplication.run(YorickApplication.class, args);
    }
}
