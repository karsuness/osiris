package com.wjx.osiris.fizz.feign.fallbackfactory;

import com.wjx.osiris.fizz.domain.Result;
import com.wjx.osiris.fizz.feign.DamoclesFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangjinxin
 * @date 2022/9/14 20:38
 * @mail wangjinxin03@corp.netease.com
 * @description
 */
@Component
@Slf4j
public class DamoclesFallbackFactory implements FallbackFactory<DamoclesFeignService> {
    @Override
    public DamoclesFeignService create(Throwable cause) {
        return new DamoclesFeignService() {
            @Override
            public Result getUser() {
                return Result.fail("911", cause.getMessage());
            }
        };
    }
}
