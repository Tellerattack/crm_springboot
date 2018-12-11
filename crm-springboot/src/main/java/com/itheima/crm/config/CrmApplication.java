package com.itheima.crm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value={"classpath:jdbc.properties", 
		"classpath:env.properties"},ignoreResourceNotFound = true)
@SpringBootApplication
@ComponentScan(basePackages="com.itheima.crm")
public class CrmApplication {
	@Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driver}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @SuppressWarnings("deprecation")
	@Bean(destroyMethod = "close")
    public DruidDataSource dataSource() {
    	DruidDataSource druidDataSource = new DruidDataSource();
        // 数据库驱动
    	druidDataSource.setDriverClassName(jdbcDriverClassName);
        // 相应驱动的jdbcUrl
    	druidDataSource.setUrl(jdbcUrl);
        // 数据库的用户名
    	druidDataSource.setUsername(jdbcUsername);
        // 数据库的密码
    	druidDataSource.setPassword(jdbcPassword);
        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
    	druidDataSource.setMaxIdle(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
    	druidDataSource.setMaxActive(30);
        return druidDataSource;
}

}
