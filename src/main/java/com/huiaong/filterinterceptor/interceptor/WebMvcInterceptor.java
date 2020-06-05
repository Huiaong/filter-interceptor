package com.huiaong.filterinterceptor.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :  Hujc
 * @version : 1.0.0
 * @date : 2020/6/4/0004 19:38
 * @description :
 */
public class WebMvcInterceptor implements HandlerInterceptor {
    private final static Logger log = LoggerFactory.getLogger(WebMvcInterceptor.class);

    /**
     * 进入controller层之前拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("WebMvcInterceptor#preHandle");
        return true;
    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("WebMvcInterceptor#postHandle");
    }

    /**
     * 视图渲染之后的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info("WebMvcInterceptor#afterCompletion");
    }
}
