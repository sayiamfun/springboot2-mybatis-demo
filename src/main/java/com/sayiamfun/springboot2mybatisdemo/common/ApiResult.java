package com.sayiamfun.springboot2mybatisdemo.common;

import lombok.Data;

/**
 * Api统一的返回结果类
 */
@Data
public class ApiResult {
    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    private ApiResult() {}

    public static ApiResult success(){
        ApiResult r = new ApiResult();
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg(ResultCode.SUCCESS.getMsg());
        return r;
    }

    public static ApiResult error(){
        ApiResult r = new ApiResult();
        r.setCode(ResultCode.ERROR.getCode());
        r.setMsg(ResultCode.ERROR.getMsg());
        return r;
    }

    public ApiResult message(String message){
        this.setMsg(message);
        return this;
    }

    public ApiResult data(Object data){
        this.setData(data);
        return this;
    }

    public ApiResult ofResultCode(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        return this;
    }

    public ApiResult ofBusinessRuntimeException(BusinessRuntimeException resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        return this;
    }


    @Override
    public String toString() {
        return "ApiResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

