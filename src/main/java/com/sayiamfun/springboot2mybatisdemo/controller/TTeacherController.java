package com.sayiamfun.springboot2mybatisdemo.controller;


import com.sayiamfun.springboot2mybatisdemo.common.ApiResult;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryTeacher;
import com.sayiamfun.springboot2mybatisdemo.common.sql.SqlParam;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.AddCheck;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.UpdateCheck;
import com.sayiamfun.springboot2mybatisdemo.entity.TTeacher;
import com.sayiamfun.springboot2mybatisdemo.service.TTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-10
 */
@Api(description = "操作教师Api")
@Controller
@RequestMapping("/tTeacher")
public class TTeacherController {

    @Autowired
    private TTeacherService teacherService;

    @ResponseBody
    @ApiOperation(value = "添加教师信息", notes = "添加教师信息")
    @ApiImplicitParam(name = "teacher", value = "教师对象", required = true, dataType = "TTeacher")
    @PostMapping("/add")
    public ApiResult addUser(@Validated(value = AddCheck.class) @RequestBody TTeacher teacher) {
        teacherService.addUser(teacher);
        return ApiResult.success();
    }

    @ResponseBody
    @ApiOperation(value = "验证表单教师信息", notes = "验证表单教师信息")
    @ApiImplicitParam(name = "teacher", value = "教师对象", required = true, dataType = "TTeacher")
    @PostMapping("/check")
    public ApiResult checkUser(@Validated(value = AddCheck.class) @RequestBody TTeacher teacher) {
        return ApiResult.success();
    }

    @ResponseBody
    @ApiOperation(value = "修改教师信息", notes = "修改教师信息")
    @ApiImplicitParam(name = "teacher", value = "教师对象", required = true, dataType = "TTeacher")
    @PutMapping("/update")
    public ApiResult updateUser(@Validated(value = UpdateCheck.class) @RequestBody TTeacher teacher) {
        teacherService.updateUser(teacher);
        return ApiResult.success();
    }

    @ResponseBody
    @ApiOperation(value = "删除教师信息", notes = "删除教师信息")
    @ApiImplicitParam(name = "teacher", value = "教师对象", required = true, dataType = "TTeacher")
    @DeleteMapping("/{teacherId}/")
    public ApiResult deleteById(
            @NotNull(message = "教师id不能为空")
            @PathVariable("teacherId")Integer teacherId
    ){

        teacherService.deleteByIds(new SqlParam("("+teacherId+")"));
        return ApiResult.success();
    }

    @ResponseBody
    @ApiOperation(value = "根据id查询教师信息", notes = "根据id查询教师信息")
    @ApiImplicitParam(name = "teacherId", value = "教师id", required = true, dataType = "int")
    @GetMapping("/{id}/")
    public ApiResult getById(
            @NotNull(message = "教师id不能为空")
            @PathVariable(name = "id") Integer id
    ) {
        TTeacher teacher = teacherService.selectById(id);
        return ApiResult.success().data(teacher);
    }

    @ResponseBody
    @ApiOperation(value = "分页查找教师信息", notes = "分页查找教师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "queryTeacher", value = "查询参数", required = true, dataType = "QueryTeacher")
    })
    @PostMapping("/all/{pageNum}/{pageSize}/")
    public ApiResult findAllUser(
            @NotNull(message = "页码不能为空")
            @PathVariable(name = "pageNum")
                    int pageNum,
            @NotNull(message = "每页条数不能为空")
            @PathVariable(name = "pageSize")
                    int pageSize,
            @RequestBody QueryTeacher queryTeacher
    ) {
        return ApiResult.success().data(teacherService.findAllUser(pageNum, pageSize, queryTeacher));
    }

    @GetMapping("/teacher.htm")
    public String loginHtml() {
        return "teacher";
    }
}

