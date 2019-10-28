package com.zzt.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description spring容器测试
 * @auther zzt
 * @since 2019-10-26 12:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationContextTest {

    @Test
    public void AnnoContextTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext();
        for (String str:ctx.getBeanDefinitionNames()){
            System.out.println(str);
        }

    }
}
