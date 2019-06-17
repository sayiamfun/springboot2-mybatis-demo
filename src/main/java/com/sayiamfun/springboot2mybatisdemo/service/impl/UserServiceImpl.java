package com.sayiamfun.springboot2mybatisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sayiamfun.springboot2mybatisdemo.common.BusinessRuntimeException;
import com.sayiamfun.springboot2mybatisdemo.common.ResultCode;
import com.sayiamfun.springboot2mybatisdemo.common.WebConst;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryUser;
import com.sayiamfun.springboot2mybatisdemo.entity.User;
import com.sayiamfun.springboot2mybatisdemo.mapper.UserMapper;
import com.sayiamfun.springboot2mybatisdemo.service.UserService;
import com.sayiamfun.springboot2mybatisdemo.utils.CookieUtil;
import com.sayiamfun.springboot2mybatisdemo.utils.JsonObjectUtils;
import com.sayiamfun.springboot2mybatisdemo.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户信息
     *
     * @param newUser
     * @return
     */
    @Override
    public boolean addUser(User newUser) {
        boolean x = CheckUserNameAndPhone(newUser);
        if (x) {
            String password = JsonObjectUtils.encodeByMD5(newUser.getPassword());
            newUser.setPassword(password);
            userMapper.insert(newUser);
        }
        return true;
    }

    /**
     * 条件分页查询用户
     *
     * @param pageNum
     * @param pageSize
     * @param queryUser
     * @return
     */
    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize, QueryUser queryUser) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectUsers(queryUser);
        PageInfo result = new PageInfo(userList);
        return result;
    }

    /**
     * 更新用户信息
     *
     * @param newUser
     * @return
     */
    @Override
    public boolean updateUser(User newUser) {
        boolean x = CheckUserNameAndPhone(newUser);
        if (x) {
            String password = JsonObjectUtils.encodeByMD5(newUser.getPassword());
            newUser.setPassword(password);
            userMapper.updateUser(newUser);
        }
        return true;
    }

    /**
     * 校验用户名和密码是否存在
     *
     * @param newUser
     * @return
     */
    private boolean CheckUserNameAndPhone(User newUser) {
        User user = userMapper.selectByUserName(newUser.getUserName());
        if (null != user && !user.getUserId().equals(newUser.getUserId())) {
            throw new BusinessRuntimeException(ResultCode.USERNAME_EXIST_ERROR);
        }
        user = userMapper.selectByPhone(newUser.getPhone());
        if (null != user && !user.getUserId().equals(newUser.getUserId())) {
            throw new BusinessRuntimeException(ResultCode.PHONE_EXIST_ERROR);
        }
        return true;
    }

    /**
     * 登录验证用户名和密码
     *
     * @param request
     * @param response
     * @param loginUser
     * @return
     */
    @Override
    public boolean login(HttpServletRequest request, HttpServletResponse response, User loginUser) {
        User user = userMapper.selectByUserName(loginUser.getUserName());
        if (null == user) {
            user = userMapper.selectByPhone(loginUser.getUserName());
        }
        if (null == user) {
            throw new BusinessRuntimeException(ResultCode.USERNAME_ERROR);
        }
        String password = JsonObjectUtils.encodeByMD5(loginUser.getPassword());
        if (!user.getPassword().equals(password)) {
            throw new BusinessRuntimeException(ResultCode.PASSWORD_ERROR);
        }
        SessionUtil.setSession(request, WebConst.SESSIONUSERKEYPRE + user.getUserId() + WebConst.SESSIONUSERKEYSUFF, JsonObjectUtils.objectToJson(user));
        CookieUtil.setCookie(request, response, WebConst.COOKIEUSERKEY, "" + user.getUserId(), 5 * 60 * 60, false);
        return true;
    }

    @Override
    public boolean checkUser(User checkUser) {
        return CheckUserNameAndPhone(checkUser);
    }
}
