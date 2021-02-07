package com.wjx.aphelios.springmvc.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author WJX
 * @since 2018/4/26 10:46
 */
public class ExceptionHandle implements HandlerExceptionResolver {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-IBF/error.html");
        return modelAndView;
    }
}
