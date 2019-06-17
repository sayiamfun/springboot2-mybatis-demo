package com.sayiamfun.springboot2mybatisdemo.common;

public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS("0", "success"),

    /**
     * 成功
     */
    ERROR("1", "error"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR("0x10001", "网页走丢了呢，请稍后刷新重试哦。。。"),

    /**
     * 用户名不存在
     */
    USERNAME_ERROR("0x10002", "用户名不存在"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR("0x10003", "密码错误"),

    /**
     * 用户名已经存在
     */
    USERNAME_EXIST_ERROR("0x10004", "用户名已经存在"),

    /**
     * 手机号已经存在
     */
    PHONE_EXIST_ERROR("0x10005", "用户名不存在"),

    /**
     * 请求方式不被允许
     */
    METHOD_NOT_SUPPORTED("0x10006", "您发送的请求有误哦。。。"),

    /**
     * 数据库异常
     */
    MYSQL_ERROR("0x10007", "数据请求正忙，请稍等一下哦。。。");

    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
