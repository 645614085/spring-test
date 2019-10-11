package com.zzt.test.DaoSupport;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Description com.zzt.test.DaoSupport
 * @auther zzt
 * @since 2019-09-01 17:55
 */
@Repository
public class SecondJdbcTemplateSupport extends JdbcDaoSupport {

    @Resource(name = "secondJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void setSecondJdbcTemplate(){
        this.setJdbcTemplate(jdbcTemplate);
    }

    public JdbcTemplate getSecondJdbcTemplate(){
        return this.getJdbcTemplate();
    }
}
