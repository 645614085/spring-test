package com.zzt.test;

import com.zzt.test.controller.UserPojo;
import com.zzt.test.mapper.UserMapperInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    private  static final Logger logger = LoggerFactory.getLogger(TestApplicationTests.class);

    @PostConstruct
    private void init() throws ClassNotFoundException {
        Class.forName(DataSourceUtils.class.getName());
    }


    @Autowired
    UserMapperInterface userMapperInterface;

    @Test
    public void contextLoads() {
        List<Integer> demo = new ArrayList<>();
        Double a = demo.stream().collect(Collectors.averagingInt(item->1));
    }

    /**
     * mybatis 测试
     */
    @Test
    public void mapperTest(){
       UserPojo userPojo = userMapperInterface.findUserByName("Auser");
        System.out.println("测试结果：");
        logger.info("获取到的测试结果{}",userPojo);
        System.out.println(userPojo);
    }


    @Resource(name = "RedissonClient")
    RedissonClient redissonClient;

    /**
     * redisson 测试
     */
    @Test
    public void redissonTest() throws ClassNotFoundException {
       RLock lock = redissonClient.getLock("redisson_lock1");
       lock.lock(10, TimeUnit.SECONDS);
       logger.info("打个日志");
        System.out.println("redisson 配置完成。。。");
       lock.unlock();

    }

}
