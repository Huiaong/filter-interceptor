package com.huiaong.filterinterceptor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author :  Hujc
 * @version : 1.0.0
 * @date : 2020/6/4/0004 19:28
 * @description :
 */
public class FirstFilter implements Filter {
    private final static Logger log = LoggerFactory.getLogger(FirstFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("First Filter#info");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("First Filter#doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("First Filter#destroy");
    }
}
