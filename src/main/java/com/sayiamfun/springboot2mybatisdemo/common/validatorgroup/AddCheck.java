package com.sayiamfun.springboot2mybatisdemo.common.validatorgroup;


import com.sayiamfun.springboot2mybatisdemo.common.validatorgroup.field.*;

import javax.validation.GroupSequence;

@GroupSequence({FieldTwo.class, FieldThree.class, FieldFour.class, FieldFive.class, FieldSix.class})
public interface AddCheck {
}
