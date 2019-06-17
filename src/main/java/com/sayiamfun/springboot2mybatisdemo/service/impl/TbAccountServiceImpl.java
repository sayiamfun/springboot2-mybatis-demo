package com.sayiamfun.springboot2mybatisdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryAccount;
import com.sayiamfun.springboot2mybatisdemo.entity.TbAccount;
import com.sayiamfun.springboot2mybatisdemo.mapper.TbAccountMapper;
import com.sayiamfun.springboot2mybatisdemo.service.TbAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public PageInfo<TbAccount> findAllAccount(int pageNum, int pageSize, QueryAccount queryAccount) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbAccount> userList = tbAccountMapper.selectAccounts(queryAccount);
        PageInfo result = new PageInfo(userList);
        return result;
    }
}
