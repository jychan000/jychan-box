package com.jychan.box.springboot.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Raymond
 * @version 15/12/7 13:40
 * @E-mail:415683089@qq.com
 */
@Configuration
@MapperScan(
        basePackages = "com.jychan.box.springboot.example.persistence.dbjychan",
        sqlSessionFactoryRef = "sqlSessionFactoryJychan"
)
public class DatabaseConfigJychan {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasourcejychan")
    public DataSource dataSourceJychan() {
        System.out.println("配置jyhan数据源");
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("sqlSessionFactoryJychan")
    public SqlSessionFactory sqlSessionFactoryJychan(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceJychan());

        return sessionFactory.getObject();
    }
}
