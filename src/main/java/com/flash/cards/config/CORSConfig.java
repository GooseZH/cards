package com.flash.cards.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 支持跨域请求
 * @author lizheng
 * @since 2018/5/15 19:03
 **/
@Configuration
public class CORSConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                .allowCredentials(false)
                .maxAge(3600);
    }
}
