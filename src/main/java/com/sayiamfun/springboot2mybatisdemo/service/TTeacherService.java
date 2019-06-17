package com.sayiamfun.springboot2mybatisdemo.service;

import com.github.pagehelper.PageInfo;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryTeacher;
import com.sayiamfun.springboot2mybatisdemo.common.sql.SqlParam;
import com.sayiamfun.springboot2mybatisdemo.entity.TTeacher;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-10
 */
public interface TTeacherService {

    boolean addUser(TTeacher teacher);

    boolean updateUser(TTeacher teacher);

    PageInfo<TTeacher> findAllUser(int pageNum, int pageSize, QueryTeacher queryTeacher);

    TTeacher selectById(Integer id);

    boolean deleteByIds(SqlParam sqlParam);
}
