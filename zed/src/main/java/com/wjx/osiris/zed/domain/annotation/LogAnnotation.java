package com.wjx.osiris.zed.domain.annotation;

import java.lang.annotation.*;

/**
 * @author wangjinxin
 * @date 2021/1/24 15:25
 * @mail wjxScott@163.com
 * @description 日志注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
}
