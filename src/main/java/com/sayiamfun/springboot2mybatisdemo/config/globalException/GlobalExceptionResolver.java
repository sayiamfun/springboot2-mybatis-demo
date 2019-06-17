package com.sayiamfun.springboot2mybatisdemo.config.globalException;

import com.sayiamfun.springboot2mybatisdemo.common.ApiResult;
import com.sayiamfun.springboot2mybatisdemo.common.BusinessRuntimeException;
import com.sayiamfun.springboot2mybatisdemo.common.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

/**
 * 全局Controller层异常处理类
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult handleException(Exception e) {
        // 打印异常堆栈信息

        if(e.getMessage().contains("SQLSyntaxErrorException")){
            LOG.error(e.getMessage());
            return ApiResult.error().ofResultCode(ResultCode.MYSQL_ERROR);
        }
        LOG.error(e.getMessage(), e);
        return ApiResult.error().ofResultCode(ResultCode.UNKNOWN_ERROR);
    }

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(BusinessRuntimeException.class)
    @ResponseBody
    public ApiResult handleOpdRuntimeException(BusinessRuntimeException e) {
        // 不打印异常堆栈信息
        LOG.error(e.getMsg());
        return ApiResult.error().ofBusinessRuntimeException(e);
    }

    /**
     * 处理所有数据验证异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler({BindException.class,MethodArgumentNotValidException.class})
    @ResponseBody
    public ApiResult handleMethodArgumentNotValidException(Exception e) {
        // 不打印异常堆栈信息
        LOG.error(e.getMessage());
        BindingResult bindResult = null;
        if (e instanceof BindException) {
            bindResult = ((BindException) e).getBindingResult();
        } else if (e instanceof MethodArgumentNotValidException) {
            bindResult = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        String msg;
        if (bindResult != null && bindResult.hasErrors()) {
            msg = bindResult.getAllErrors().get(0).getDefaultMessage();
        }else {
            msg = "系统繁忙，请稍后重试...";
        }
        return ApiResult.error().message(msg);
    }

    /**
     * 处理所有请求不被处理异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ApiResult handleOpdRuntimeException(HttpRequestMethodNotSupportedException e) {
        // 不打印异常堆栈信息
        LOG.error(e.getMessage());
        return ApiResult.error().ofResultCode(ResultCode.METHOD_NOT_SUPPORTED);
    }

    /**
     * 处理所有数据库异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler({SQLSyntaxErrorException.class, SQLException.class})
    @ResponseBody
    public ApiResult handleSQLException(SQLException e) {
        // 不打印异常堆栈信息
        LOG.error(e.getMessage());
        return ApiResult.error().ofResultCode(ResultCode.MYSQL_ERROR);
    }
}

