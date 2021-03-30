package com.wjx.osiris.jhin.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
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

    @Pointcut("@within(com.wjx.qilin.annotation.LogAnnotation)")
    private void pointCut() {
    }


    @Around("pointCut()")
    public Object doAroundForLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        Map<String, Object> params = this.getParams(proceedingJoinPoint);
        log.info("开始调用{}类的{}方法,参数是{}", className, methodName, params);
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        Class returnType = methodSignature.getReturnType();
        log.info("请求耗时：{} 毫秒", (System.currentTimeMillis() - startTime));
        if (Objects.equals(Void.TYPE, returnType)) {
            log.info("请求{}类的{}方法返回类型为void，无返回值", className, methodName);
        } else {
            log.info("请求{}类的{}方法处理完毕，返回结果为{}", className, methodName, result);
        }
        return result;
    }

    /**
     * 获取请求参数
     *
     * @param proceedingJoinPoint
     * @return
     */
    private Map<String, Object> getParams(ProceedingJoinPoint proceedingJoinPoint) {
        Map<String, Object> requestParams = new HashMap<>();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //参数名
        String[] parameterNames = signature.getParameterNames();
        //参数值
        Object[] parameterValues = proceedingJoinPoint.getArgs();

        for (int i = 0; i < parameterNames.length; i++) {
            Object value = parameterValues[i];

            //如果对象是文件对象,获取文件名
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                value = file.getOriginalFilename();
            }
            requestParams.put(parameterNames[i], value);
        }
        return requestParams;
    }
}
