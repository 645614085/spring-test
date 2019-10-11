package com.zzt.test.DaoSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description com.zzt.test.DaoSupport
 * @auther zzt
 * @since 2019-08-30 13:54
 */
@Repository
public class PrimaryJdbcTemplateSupport extends JdbcDaoSupport {

    @Resource(name = "primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    void setPrimaryJdbcTemplate(){
        setJdbcTemplate(jdbcTemplate);
    }


    public JdbcTemplate getPrimaryJdbc(){
       return getJdbcTemplate();
    }

}
