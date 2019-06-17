package com.sayiamfun.springboot2mybatisdemo.common.requestentity;

import lombok.Data;

@Data
public class QueryTeacher {

    private String teacherName;
    private String teacherEmail;
    private String teacherClass;
    private String teacherSubject;


    public String getTeacherName() {
        if (null != teacherName && teacherName.length() > 0)
            return "%" + teacherName + "%";
        return teacherName;
    }

    public String getTeacherEmail() {
        if (null != teacherEmail && teacherEmail.length() > 0)
            return "%" + teacherEmail + "%";
        return teacherEmail;
    }
}
