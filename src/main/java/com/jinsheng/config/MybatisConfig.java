package com.jinsheng.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sql = new SqlSessionFactoryBean();
        //设置类型别名
        sql.setTypeAliasesPackage("com.jinsheng.domain");
        sql.setDataSource(dataSource);
        return sql;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapper = new MapperScannerConfigurer();
        //返回mapper代理的位置
        mapper.setBasePackage("com.jinsheng.dao");
        return mapper;
    }
}
