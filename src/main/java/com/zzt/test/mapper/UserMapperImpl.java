package com.zzt.test.mapper;

import com.zzt.test.controller.UserPojo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Description com.zzt.test.mapper
 * @auther zzt
 * @since 2019-09-09 17:36
 */
@Repository
public class UserMapperImpl implements UserMapperInterface {

    @Resource(name = "primarySqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public UserPojo findUserByName(String name) {
       UserPojo userPojo = sqlSessionTemplate.selectOne("com.zzt.test.mapper.UserMapperInterface.findUserByName",name);
       return userPojo;
    }
}
