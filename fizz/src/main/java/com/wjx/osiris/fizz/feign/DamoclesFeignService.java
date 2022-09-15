package com.wjx.osiris.fizz.feign;

import com.wjx.osiris.fizz.domain.Result;
import com.wjx.osiris.fizz.feign.fallbackfactory.DamoclesFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangjinxin
 * @date 2022/9/14 20:37
 * @mail wangjinxin03@corp.netease.com
 * @description
 */
@FeignClient(name = "damocles", path = "/damocles", fallbackFactory = DamoclesFallbackFactory.class)
public interface DamoclesFeignService {

    @GetMapping("/test/get_all_user")
    Result getUser();
}
