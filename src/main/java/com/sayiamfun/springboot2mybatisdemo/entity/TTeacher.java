package com.sayiamfun.springboot2mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.field.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 * 
 * </p>
 *
 * @author sayiamfun
 * @since 2019-06-10
 */
@Data
public class TTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @NotNull(message = "教师ID不能为空", groups = {FieldOne.class})
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    /**
     * 教师名称
     */
    @NotBlank(message = "教师名称不能为空", groups = {FieldTwo.class})
    @Size(min = 2,max = 12, message = "教师名称长度必须为2-12", groups = {FieldTwo.class})
    private String teacherName;

    /**
     * 教师年龄
     */
    @NotNull(message = "教师年龄不能为空", groups = {FieldThree.class})
    @DecimalMin(value = "0", message = "年龄最小为0", groups = {FieldThree.class})
    private Integer teacherAge;

    /**
     * 教师邮箱
     */
    @NotBlank(message = "教师邮箱不能为空", groups = {FieldFour.class})
    @Email(message = "邮箱格式不对", groups = {FieldFour.class})
    private String teacherEmail;

    /**
     * 教师所教年级
     */
    @Length(min = 0, max = 25, message = "所教年级超出长度了哦", groups = {FieldFive.class})
    private String teacherClass;

    /**
     * 教师所教科目
     */
    @Length(min = 0, max = 25, message = "所教科目超出长度了哦", groups = {FieldSix.class})
    private String teacherSubject;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TTeacher tTeacher = (TTeacher) o;
        return Objects.equals(teacherId, tTeacher.teacherId) &&
                Objects.equals(teacherName, tTeacher.teacherName) &&
                Objects.equals(teacherAge, tTeacher.teacherAge) &&
                Objects.equals(teacherEmail, tTeacher.teacherEmail) &&
                Objects.equals(teacherClass, tTeacher.teacherClass) &&
                Objects.equals(teacherSubject, tTeacher.teacherSubject) &&
                Objects.equals(deleted, tTeacher.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherName, teacherAge, teacherEmail, teacherClass, teacherSubject, deleted);
    }

    @Override
    public String toString() {
        return "TTeacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAge=" + teacherAge +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherClass='" + teacherClass + '\'' +
                ", teacherSubject='" + teacherSubject + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
