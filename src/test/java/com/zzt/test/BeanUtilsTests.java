package com.zzt.test;

import com.zzt.test.controller.UserCopyPojo;
import com.zzt.test.controller.UserPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description com.zzt.test
 * @auther zzt
 * @since 2019-10-15 14:29
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanUtilsTests {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtilsTests.class);


    @Test
    public void beanCopy(){
        UserPojo  userPojo= new UserPojo();
        userPojo.setId(1);
        userPojo.setName("name");
        userPojo.setPwd("pwd");
        userPojo.setEmail("645614085@qq.com");
        logger.info("源数据：{}",userPojo);
        UserCopyPojo userCopyPojo = new UserCopyPojo();
        BeanUtils.copyProperties(userPojo,userCopyPojo);
        logger.info("copy数据：{}",userCopyPojo);
    }
}
