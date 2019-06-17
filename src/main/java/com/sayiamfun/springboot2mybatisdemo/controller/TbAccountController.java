package com.sayiamfun.springboot2mybatisdemo.controller;


import com.sayiamfun.springboot2mybatisdemo.common.ApiResult;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryAccount;
import com.sayiamfun.springboot2mybatisdemo.service.TbAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-14
 */
@Api(description = "余额API")
@Controller
@RequestMapping("/tbAccount")
public class TbAccountController {

    @Autowired
    private TbAccountService tbAccountService;

    @ResponseBody
    @ApiOperation(value = "分页查找余额信息", notes = "分页查找余额信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "queryAccount", value = "查询参数", required = true, dataType = "QueryAccount")
    })
    @PostMapping("/all/{pageNum}/{pageSize}/")
    public ApiResult findAllAccount(
            @NotNull(message = "页码不能为空")
            @PathVariable(name = "pageNum")
                    int pageNum,
            @NotNull(message = "每页条数不能为空")
            @PathVariable(name = "pageSize")
                    int pageSize,
            @RequestBody QueryAccount queryAccount
    ) {
        return ApiResult.success().data(tbAccountService.findAllAccount(pageNum, pageSize, queryAccount));
    }

}

