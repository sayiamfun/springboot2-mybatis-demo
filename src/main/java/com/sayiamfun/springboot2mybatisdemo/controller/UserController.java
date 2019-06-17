package com.sayiamfun.springboot2mybatisdemo.controller;

import com.sayiamfun.springboot2mybatisdemo.common.ApiResult;
import com.sayiamfun.springboot2mybatisdemo.common.WebConst;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryUser;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.AddCheck;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.LoginCheck;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.UpdateCheck;
import com.sayiamfun.springboot2mybatisdemo.entity.User;
import com.sayiamfun.springboot2mybatisdemo.service.UserService;
import com.sayiamfun.springboot2mybatisdemo.utils.CookieUtil;
import com.sayiamfun.springboot2mybatisdemo.utils.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@Api(description = "操作用户Api")
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
    @PostMapping("/add")
    public ApiResult addUser(@Validated(value = AddCheck.class) @RequestBody User user) {
            boolean result = userService.addUser(user);
            if (!result) {
                return ApiResult.error();
            }
            return ApiResult.error();

    }

    @ResponseBody
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
    @PutMapping("/update")
    public ApiResult updateUser(@Validated(value = UpdateCheck.class) @RequestBody User user) {
        boolean result = userService.updateUser(user);
        if (!result) {
            return ApiResult.error();
        }
        return ApiResult.success();
    }

    @ResponseBody
    @ApiOperation(value = "分页查找用户信息", notes = "分页查找用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "queryUser", value = "查询参数", required = true, dataType = "QueryUser")
    })
    @PostMapping("/all/{pageNum}/{pageSize}/")
    public ApiResult findAllUser(
            @NotNull(message = "页码不能为空")
            @PathVariable(name = "pageNum")
                    int pageNum,
            @NotNull(message = "每页条数不能为空")
            @PathVariable(name = "pageSize")
                    int pageSize,
            @RequestBody QueryUser queryUser
    ) {
        return ApiResult.success().data(userService.findAllUser(pageNum, pageSize, queryUser));
    }

    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParam(name = "loginUser", value = "用户对象", required = true, dataType = "User")
    @PostMapping("/login")
    public ApiResult login(@Validated(value = LoginCheck.class) @RequestBody User loginUser, HttpServletRequest request, HttpServletResponse response) {
        boolean result = userService.login(request, response, loginUser);
        if (!result) {
            return ApiResult.error();
        }
        return ApiResult.success();
    }

    @ResponseBody
    @ApiOperation(value = "用户退出", notes = "用户退出")
    @GetMapping("/loginOut")
    public ApiResult loginOut(HttpServletRequest request, HttpServletResponse response) {
        String cookieValue = CookieUtil.getCookieValue(request, WebConst.COOKIEUSERKEY, false);
        System.err.println(cookieValue);
        if(null != cookieValue){
            CookieUtil.deleteCookie(request, response, WebConst.COOKIEUSERKEY);
            SessionUtil.removeSession(request, WebConst.SESSIONUSERKEYPRE+cookieValue+WebConst.SESSIONUSERKEYSUFF);
        }
        return ApiResult.success();
    }

    @ResponseBody
    @ApiOperation(value = "用户校验", notes = "用户校验")
    @ApiImplicitParam(name = "checkUser", value = "用户对象", required = true, dataType = "User")
    @PostMapping("/check")
    public ApiResult checkUser(@Validated(value = AddCheck.class) @RequestBody User checkUser) {
        return ApiResult.success();
    }


    @GetMapping("/login.htm")
    public String loginHtml() {
        return "login";
    }
}
