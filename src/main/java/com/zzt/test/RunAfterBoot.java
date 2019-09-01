package com.zzt.test;

import com.zzt.test.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Description com.zzt.test
 * @auther zzt
 * @since 2019-08-01 16:47
 */
@Component
public class RunAfterBoot implements ApplicationRunner {

    @Autowired
    private Config config;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("获取的配置如下：");
        config.getAllProperties();
    }
}
