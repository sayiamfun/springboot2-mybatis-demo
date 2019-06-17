package com.sayiamfun.springboot2mybatisdemo.common.requestentity;

import lombok.Data;

@Data
public class QueryUser {

    private String userName;
    private String phone;

    public String getUserName() {
        if (null != userName && userName.length() > 0)
            return "%" + userName + "%";
        return null;
    }

    public String getPhone() {
        if (null != phone && phone.length() > 0)
            return "%" + phone + "%";
        return null;
    }
}
