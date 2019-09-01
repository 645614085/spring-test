package com.zzt.test;

import com.zzt.test.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {


    @Autowired
    Config config;

    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
    }

}