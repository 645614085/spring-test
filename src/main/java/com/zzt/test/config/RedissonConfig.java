package com.zzt.test.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description com.zzt.test.config
 * @auther zzt
 * @since 2019-10-12 17:14
 */
@Configuration
public class RedissonConfig {

    @Value("${redisson.addr}")
    private String addr;

    @Value("${redisson.pwd}")
    private String pwd;

    @Bean(name = "RedissonClient")
    public RedissonClient getRedisson(){
        Config config = new Config();
        config.useSingleServer().setAddress(addr).setPassword(pwd);
        return Redisson.create(config);
    }
}
