package com.wangzhe.blog.common.validated;

import com.wangzhe.blog.common.validated.annotation.CustomerEmail;
import com.wangzhe.blog.utils.CommonUtil;
import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author WangZhe
 * @version 1.0
 * @className CustomerEmailValidator
 * @description
 * @date 2022/8/5 10:18
 */
@Log4j2
public class CustomerEmailValidator implements ConstraintValidator<CustomerEmail, String> {
    @Override
    public void initialize(CustomerEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        log.info(o);
        return CommonUtil.checkEmail(o);
    }
}
