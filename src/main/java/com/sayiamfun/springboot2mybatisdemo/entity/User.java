package com.sayiamfun.springboot2mybatisdemo.entity;

import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.field.FieldFour;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.field.FieldOne;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.field.FieldThree;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.field.FieldTwo;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
public class User {

    /**
     * 用户id
     */
    @NotNull(message = "用户ID不能为空", groups = {FieldOne.class})
    private Integer userId;

    /**
     * 用户姓名
     */
    @NotBlank(message = "用户名称不能为空", groups = {FieldTwo.class})
    @Length(min = 2,max = 12, message = "用户名长度必须为2-12", groups = {FieldTwo.class})
    private String userName;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空", groups = {FieldThree.class})
    @Length(min = 6,max = 12, message = "用户密码长度必须为6-12", groups = {FieldThree.class})
    private String password;

    /**
     * 手机号
     */
    @NotBlank(message = "用户手机号码不能为空",groups = {FieldFour.class})
    @Length(min = 11,max = 11, message = "手机号码格式不正确",groups = {FieldFour.class})
    private String phone;

    /**
     * 逻辑删除状态
     */
    private Integer deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(deleted, user.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, phone, deleted);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
