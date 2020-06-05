package com.huiaong.filterinterceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  Hujc
 * @version : 1.0.0
 * @date : 2020/6/4/0004 19:48
 * @description :
 */
@RestController
@RequestMapping("/filter/interceptor")
public class filterInterceptorController {
    private final static Logger log = LoggerFactory.getLogger(filterInterceptorController.class);

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        log.info("filterInterceptorController#hello");
        return "hello";
    }

}
