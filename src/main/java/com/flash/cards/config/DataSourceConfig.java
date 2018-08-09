package com.flash.cards.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据源配置    （使用Druid）
 *
 * @author lizheng
 * @since 2018/6/27 9:52
 **/
@Configuration
@PropertySource(value = {"classpath:data-source.properties"})
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${spring.datasource.maxEvictableIdleTimeMillis}")
    private int maxEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;
    @Value("${spring.datasource.useGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat;
    @Value("${spring.datasource.keepAlive}")
    private boolean keepAlive;

    @Bean
    @Primary
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        // 初始化链接
        datasource.setInitialSize(initialSize);
        // 最小闲置链接
        datasource.setMinIdle(minIdle);
        // 最大活动链接
        datasource.setMaxActive(maxActive);
        // 获取链接的等待时长（超时后会新建）
        datasource.setMaxWait(maxWait);
        // 检测链接的时间
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
        // 检测链接是否有效
        datasource.setValidationQuery(validationQuery);
        // 申请链接的时候检测，空闲时间是否大于timeBetweenEvictionRunsMillis，若大于执行validationQuery
        datasource.setTestWhileIdle(testWhileIdle);
        // 申请链接的时候执行validationQuery
        datasource.setTestOnBorrow(testOnBorrow);
        //
        datasource.setTestOnReturn(testOnReturn);
        // 是否缓存preparedStatement，游标库开启
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);

        datasource.setKeepAlive(true);
        // 处理没有还回连接池的链接
        datasource.setRemoveAbandoned(true);
        datasource.setRemoveAbandonedTimeout(60);
        datasource.setLogAbandoned(true);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: "+ e);
        }
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }
}
