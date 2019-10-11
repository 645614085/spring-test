package com.zzt.test.mapper;

import com.zzt.test.controller.UserPojo;

/**
 * @Description com.zzt.test.entity
 * @auther zzt
 * @since 2019-09-01 18:39
 */

public interface UserMapperInterface {

    UserPojo findUserByName(String name );
}
