package com.wjx.osiris.zed.domain.aspect;

import cn.hutool.extra.servlet.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author wangjinxin
 * @date 2021/1/24 15:20
 * @mail wjxScott@163.com
 * @description 日志切面
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)||@annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "||@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void pointCut() {
    }

    @Pointcut("@within(com.wjx.osiris.zed.domain.annotation.LogAnnotation)")
    private void pointCutLog() {
    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("接收到请求，请求地址为{},请求url参数为{},方法入参为{},客户端ip为{}",
                request.getRequestURI(), ServletUtil.getParamMap(request), proceedingJoinPoint.getArgs(),
                ServletUtil.getClientIP(request));
        Object result = proceedingJoinPoint.proceed();
        log.info("请求处理完毕，返回结果为{}", result);
        return result;
    }

    @Around("pointCutLog()")
    public Object doAroundForLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("开始调用{}类的{}方法,参数是{}", className, methodName, args);
        Object result = proceedingJoinPoint.proceed();
        Class returnType = methodSignature.getReturnType();
        if (Objects.equals(Void.TYPE, returnType)) {
            log.info("请求方法返回类型为void，无返回值");
        } else {
            log.info("请求处理完毕，返回结果为{}", result);
        }
        return result;
    }
}
