package com.sayiamfun.springboot2mybatisdemo.common.requestentity;

import lombok.Data;

@Data
public class QueryAccount {

    private String name;

    public String getName() {
        if (null != name && name.length() > 0)
            return "%" + name + "%";
        return null;
    }
}
