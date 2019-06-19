package com.sayiamfun.springboot2mybatisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryTeacher;
import com.sayiamfun.springboot2mybatisdemo.common.sql.SqlParam;
import com.sayiamfun.springboot2mybatisdemo.entity.TTeacher;
import com.sayiamfun.springboot2mybatisdemo.mapper.TTeacherMapper;
import com.sayiamfun.springboot2mybatisdemo.service.TTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-10
 */
@Service
public class TTeacherServiceImpl implements TTeacherService {

    @Autowired
    private TTeacherMapper teacherMapper;

    /**
     * 添加教师信息
     *
     * @param teacher
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUser(TTeacher teacher) {
        return teacherMapper.insert(teacher)>0;
    }

    /**
     * 更新教师信息
     *
     * @param teacher
     * @return
     */
    @Override
    public boolean updateUser(TTeacher teacher) {
        return teacherMapper.updateTeacher(teacher)>0;
    }

    /**
     * 分页条件查询教师信息
     *
     * @param pageNum
     * @param pageSize
     * @param queryTeacher
     * @return
     */
    @Override
    public PageInfo<TTeacher> findAllUser(int pageNum, int pageSize, QueryTeacher queryTeacher) {
        PageHelper.startPage(pageNum, pageSize);
        List<TTeacher> userList = teacherMapper.selectTeachers(queryTeacher);
        PageInfo result = new PageInfo(userList);
        return result;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public TTeacher selectById(Integer id) {
        return teacherMapper.selectById(id);
    }

    /**
     * 根据id删除
     * @param sqlParam
     * @return
     */
    @Override
    public boolean deleteByIds(SqlParam sqlParam) {
        return teacherMapper.deleteById(sqlParam)>0;
    }
}
