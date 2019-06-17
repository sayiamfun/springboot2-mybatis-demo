package com.sayiamfun.springboot2mybatisdemo.common.validatorgroup;

import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.field.FieldThree;
import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.field.FieldTwo;

import javax.validation.GroupSequence;

@GroupSequence({FieldTwo.class, FieldThree.class})
public interface LoginCheck {
}
