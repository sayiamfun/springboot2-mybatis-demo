package com.sayiamfun.springboot2mybatisdemo.mapper;

import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryAccount;
import com.sayiamfun.springboot2mybatisdemo.entity.TbAccount;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-14
 */
public interface TbAccountMapper{

    List<TbAccount> selectAccounts(QueryAccount queryAccount);
}
