package com.zzt.test.config;

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

    @Autowired
    private Environment env;


    public void getAllProperties(){
         String[] str = env.getDefaultProfiles();
        System.out.println("开始获取配置：");

        Map check = new ConcurrentHashMap();

        System.out.println(env.getProperty("zzt.name"));
         for (String e:str){
             System.out.println(e);
         }
    }
}
