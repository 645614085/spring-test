package com.zzt.test.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Description com.zzt.test.config
 * @auther zzt
 * @since 2019-09-09 17:37
 */
@Configuration
public class MapperSqlSessionConfig {

    @Resource(name = "primaryDataSource")
    private DataSource primaryDataSource;

    @Resource(name = "secondDataSource")
    private DataSource secondDataSource;

    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory getPrimarySqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlFbean = new SqlSessionFactoryBean();
        sqlFbean.setDataSource(primaryDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlFbean.setMapperLocations(resolver.getResources("classpath:mapper1/*.xml"));
        return sqlFbean.getObject();
    }


    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory getSecondSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlFbean = new SqlSessionFactoryBean();
        sqlFbean.setDataSource(secondDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlFbean.setMapperLocations(resolver.getResources("classpath:mapper2/*.xml"));
        return sqlFbean.getObject();
    }

    @Bean(name = "primarySqlSessionTemplate")
    public SqlSessionTemplate getPrimarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionTemplate getSecondSqlSessionFactory(@Qualifier("secondSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "primarySqlSession")
    public SqlSession primarySqlSession() throws Exception {
         return  getPrimarySqlSessionFactory().openSession();
    }

    @Bean(name = "secondSqlSession")
    public SqlSession secondSqlSession() throws Exception {
        return getSecondSqlSessionFactory().openSession();
    }


}
