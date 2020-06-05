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
public class ThirdFilter implements Filter {
    private final static Logger log = LoggerFactory.getLogger(ThirdFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("Third Filter#info");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Third Filter#doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("Third Filter#destroy");
    }
}
