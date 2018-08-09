package com.flash.cards.config;

import com.flash.cards.core.redis.JedisFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 程序启动时，配置Redis
 * @author lizheng
 * @since 2018/8/6 11:25
 **/
@Configuration
@PropertySource(value = "classpath:redis.properties")
public class RedisConfig implements InitializingBean {
    @Value("${redis.address}")
    private String address;

    @Override
    public void afterPropertiesSet() throws Exception {
        JedisFactory.init(address);
    }
}
