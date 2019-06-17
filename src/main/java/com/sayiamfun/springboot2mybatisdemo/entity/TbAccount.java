package com.sayiamfun.springboot2mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 * 
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-14
 */
@Data
public class TbAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 账户余额
     */
    private Float balance;

    /**
     * 逻辑删除
     */
    private Integer deleted;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAccount tbAccount = (TbAccount) o;
        return Objects.equals(id, tbAccount.id) &&
                Objects.equals(name, tbAccount.name) &&
                Objects.equals(balance, tbAccount.balance) &&
                Objects.equals(deleted, tbAccount.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance, deleted);
    }

    @Override
    public String toString() {
        return "TbAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", deleted=" + deleted +
                '}';
    }
}
