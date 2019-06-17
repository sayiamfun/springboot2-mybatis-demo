package com.sayiamfun.springboot2mybatisdemo.service;


import com.github.pagehelper.PageInfo;
import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryAccount;
import com.sayiamfun.springboot2mybatisdemo.entity.TbAccount;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-14
 */
public interface TbAccountService {

    PageInfo<TbAccount> findAllAccount(int pageNum, int pageSize, QueryAccount queryAccount);

}
