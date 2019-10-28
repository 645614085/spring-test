package com.zzt.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description com.zzt.test
 * @auther zzt
 * @since 2019-08-01 16:30
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:application-check.properties")
})
public class Config {

    private final static Logger logger = LoggerFactory.getLogger(Config.class);

    @Autowired
    private Environment env;


    public void getAllProperties(){
         String[] str = env.getDefaultProfiles();
         logger.info("开始获取配置：{}",env.getProperty("zzt.name"));
         for (String e:str){
             showProperties(e);
         }
    }


    private void showProperties(String properties){
        logger.info("配置参数：{}",properties);
    }
}
