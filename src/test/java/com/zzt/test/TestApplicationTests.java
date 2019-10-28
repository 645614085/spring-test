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
import java.util.Random;
import java.util.concurrent.CountDownLatch;
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


    private Integer auto=0;

    CountDownLatch countDownLatch = new CountDownLatch(1000);

    /**
     * redisson 测试
     */
    @Test
    public void redissonTest() throws ClassNotFoundException, InterruptedException {

        Thread.currentThread().setName("主线程：");

        for (int i=0;i<1000;i++){
            new Thread(() -> {
//                  RLock  lock = redissonClient.getLock("redission_test3");
//                  lock.lock(10,TimeUnit.SECONDS);
                  logger.info("变量值：[auto={}]",++auto);
//                  lock.unlock();
                   Random a = new Random();
                  countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();

       RLock lock = redissonClient.getLock("redisson_lock1");
       lock.lock(10, TimeUnit.SECONDS);
       logger.info("打个日志");
       logger.error("打个日志");
       logger.warn("打个日志");
       lock.unlock();
    }



}
