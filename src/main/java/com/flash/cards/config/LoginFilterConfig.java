package com.flash.cards.config;

import com.flash.cards.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * SPRING BOOT 配置文件
 * @author lizheng
 * @since 2018/5/9 16:25
 **/
@Configuration
@PropertySource(value = "classpath:local/application.properties", ignoreResourceNotFound = true)
public class LoginFilterConfig {

    @Bean
    public FilterRegistrationBean registration() {
        // filter
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setName("LoginFilter");
        registration.setOrder(1);
        registration.addUrlPatterns("/*");
        // TODO 添加过滤器
        registration.setFilter(new LoginFilter());

        return registration;

    }
}
