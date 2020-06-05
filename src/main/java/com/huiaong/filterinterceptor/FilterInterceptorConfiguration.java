package com.huiaong.filterinterceptor;

import com.huiaong.filterinterceptor.filter.FirstFilter;
import com.huiaong.filterinterceptor.filter.SecondFilter;
import com.huiaong.filterinterceptor.filter.ThirdFilter;
import com.huiaong.filterinterceptor.interceptor.AuthInterceptor;
import com.huiaong.filterinterceptor.interceptor.WebMvcInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :  Hujc
 * @version : 1.0.0
 * @date : 2020/6/4/0004 19:24
 * @description :
 */
@Configuration
public class FilterInterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebMvcInterceptor()).addPathPatterns("/**").excludePathPatterns("/error/**");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/error/**");
    }

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public WebMvcInterceptor webMvcInterceptor() {
        return new WebMvcInterceptor();
    }

    @Bean
    public ThirdFilter thirdFilter() {
        return new ThirdFilter();
    }

    @Bean
    public SecondFilter secondFilter() {
        return new SecondFilter();
    }

    @Bean
    public FirstFilter firstFilter() {
        return new FirstFilter();
    }

    /**
     * SecondFilter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<ThirdFilter> thirdRegistration() {
        FilterRegistrationBean<ThirdFilter> registration = new FilterRegistrationBean<>();
        registration.setName("ThirdFilter");
        registration.setOrder(3);
        registration.addUrlPatterns("/*");
        registration.setFilter(thirdFilter());
        return registration;
    }

    /**
     * SecondFilter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<SecondFilter> secondRegistration() {
        FilterRegistrationBean<SecondFilter> registration = new FilterRegistrationBean<>();
        registration.setName("SecondFilter");
        registration.setOrder(2);
        registration.addUrlPatterns("/*");
        registration.setFilter(secondFilter());
        return registration;
    }

    /**
     * FirstFilter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<FirstFilter> firstRegistration() {
        FilterRegistrationBean<FirstFilter> registration = new FilterRegistrationBean<>();
        registration.setName("FirstFilter");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        registration.setFilter(firstFilter());
        return registration;
    }
}
