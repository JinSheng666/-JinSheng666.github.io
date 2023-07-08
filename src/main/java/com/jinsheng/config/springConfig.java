package com.jinsheng.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.jinsheng.service"})
@PropertySource("classpath:Jdbc.properties")
@Import({MybatisConfig.class,JdbcConfig.class})
/*添加事务处理*/
@EnableTransactionManagement
public class springConfig {
}
