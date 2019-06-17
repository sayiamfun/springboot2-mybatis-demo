package com.sayiamfun.springboot2mybatisdemo.service;

import com.github.pagehelper.PageInfo;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryUser;
import com.sayiamfun.springboot2mybatisdemo.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    boolean addUser(User newUser);

    PageInfo<User> findAllUser(int pageNum, int pageSize, QueryUser queryUser);

    boolean updateUser(User newUser);

    boolean login(HttpServletRequest request, HttpServletResponse response, User loginUser);

    boolean checkUser(User checkUser);
}
