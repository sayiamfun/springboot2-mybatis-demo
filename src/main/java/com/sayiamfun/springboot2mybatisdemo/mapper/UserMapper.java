package com.sayiamfun.springboot2mybatisdemo.mapper;

import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryUser;
import com.sayiamfun.springboot2mybatisdemo.entity.User;

import java.util.List;

public interface UserMapper {

    int insert(User user);

    List<User> selectUsers(QueryUser queryUser);

    int updateUser(User user);

    User selectByUserName(String userName);

    User selectByPhone(String userName);
}
