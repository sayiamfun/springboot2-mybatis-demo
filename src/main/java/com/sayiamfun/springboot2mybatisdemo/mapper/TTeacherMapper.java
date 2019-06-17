package com.sayiamfun.springboot2mybatisdemo.mapper;

import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryTeacher;
import com.sayiamfun.springboot2mybatisdemo.common.sql.SqlParam;
import com.sayiamfun.springboot2mybatisdemo.entity.TTeacher;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-10
 */
public interface TTeacherMapper{

    Integer insert(TTeacher teacher);

    Integer updateTeacher(TTeacher teacher);

    List<TTeacher> selectTeachers(QueryTeacher queryTeacher);

    TTeacher selectById(Integer id);

    Integer deleteById(SqlParam sqlParam);
}
