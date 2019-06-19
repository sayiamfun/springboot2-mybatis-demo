package com.sayiamfun.springboot2mybatisdemo.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class TbAccount {

    private Integer id;

    private String name;

    private Float balance;

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