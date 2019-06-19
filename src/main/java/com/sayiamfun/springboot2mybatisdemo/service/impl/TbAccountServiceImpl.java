package com.sayiamfun.springboot2mybatisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryAccount;
import com.sayiamfun.springboot2mybatisdemo.entity.TTeacher;
import com.sayiamfun.springboot2mybatisdemo.entity.TbAccount;
import com.sayiamfun.springboot2mybatisdemo.mapper.TTeacherMapper;
import com.sayiamfun.springboot2mybatisdemo.mapper.TbAccountMapper;
import com.sayiamfun.springboot2mybatisdemo.service.TTeacherService;
import com.sayiamfun.springboot2mybatisdemo.service.TbAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-14
 */
@Service
public class TbAccountServiceImpl implements TbAccountService {

    @Autowired
    private TbAccountMapper tbAccountMapper;
    @Autowired
    private TTeacherService teacherService;

    /**
     * 分页查余额信息
     * @param pageNum
     * @param pageSize
     * @param queryAccount
     * @return
     */
    @Override
    public PageInfo<TbAccount> findAllAccount(int pageNum, int pageSize, QueryAccount queryAccount) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbAccount> userList = tbAccountMapper.selectAccounts(queryAccount);
        PageInfo result = new PageInfo(userList);
        return result;
    }

    /**
     * 插入余额信息
     * @param tbAccount
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addAccount(TbAccount tbAccount) {
        tbAccountMapper.insert(tbAccount);
        TTeacher tTeacher = new TTeacher();
        tTeacher.setTeacherName("test");
        tTeacher.setTeacherAge(20);
        tTeacher.setTeacherEmail("test@163.com");
        tTeacher.setDeleted(0);
        teacherService.addUser(tTeacher);
        return 1;
    }
}
