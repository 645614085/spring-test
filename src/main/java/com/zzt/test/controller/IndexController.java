package com.zzt.test.controller;

import com.zzt.test.DaoSupport.PrimaryJdbcTemplateSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * @Description com.zzt.test.controller
 * @auther zzt
 * @since 2019-08-15 14:38
 */
@RestController
public class IndexController {

    @Resource(name = "primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Resource
    private PrimaryJdbcTemplateSupport primaryJdbcTemplateSupport;

    @Autowired
    @Qualifier("secondJdbcTemplate")
    private JdbcTemplate secondJdbcTemplate;


    private List<String> ints = new ArrayList<>();

    @RequestMapping("/index")
    public List<String> getList(){
        ints.add(Thread.currentThread().getName());
        return ints;
    }

    /**
     * Http Client
     */
    @GetMapping("/testdb")
    public void testDb(){
        RowMapper rowMapper = new BeanPropertyRowMapper<>(UserPojo.class);
        List userPojos =  secondJdbcTemplate.query("select id as id,user_name as name,user_password as pwd,user_email as email from blog_user",rowMapper);
        userPojos.forEach(out::println);

        List userPojoList = jdbcTemplate.query("select id as id,user_name as name,user_password as pwd,user_email as email from blog_user",rowMapper);
        userPojoList.forEach(out::println);
    }


    @GetMapping("/supportdb")
    public void getSupport() throws SQLException {
        RowMapper rowMapper = new BeanPropertyRowMapper<>(UserPojo.class);
        System.out.println("获取子对象："+primaryJdbcTemplateSupport.getPrimaryJdbc());
        primaryJdbcTemplateSupport.getPrimaryJdbc().query(" select id as id,user_name as name,user_password as pwd,user_email as email from blog_user",rowMapper).forEach(out::println);
    }


    private void testAop(){
        System.out.println("test sop");
    }
}
