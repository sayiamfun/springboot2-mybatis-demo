package com.sayiamfun.springboot2mybatisdemo.mapper;

import com.sayiamfun.springboot2mybatisdemo.common.requestentity.QueryAccount;
import com.sayiamfun.springboot2mybatisdemo.entity.TbAccount;

import java.util.List;

public interface TbAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbAccount record);

    int insertSelective(TbAccount record);

    TbAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbAccount record);

    int updateByPrimaryKey(TbAccount record);

    List<TbAccount> selectAccounts(QueryAccount queryAccount);
}