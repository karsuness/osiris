package com.wjx.osiris.galio.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liusha
 * @date 2022/4/18 08:55
 * @mail liusha@wacai.com
 * @description
 */
@Configuration
@MapperScan("com.wjx.osiris")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
