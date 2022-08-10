package com.wangzhe.blog.utils;

import cn.hutool.core.bean.BeanUtil;
import com.wangzhe.blog.common.result.ResultCode;
import com.wangzhe.blog.entity.UserAuthDetails;
import com.wangzhe.blog.exception.BizException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author WangZhe
 * @version 1.0
 * @className SecurityUtil
 * @description security工具类
 * @date 2022/8/9 9:12
 */

public class SecurityUtil {
    public static UserAuthDetails getUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(BeanUtil.isEmpty(principal)) {
            throw new BizException(ResultCode.NOT_LOGIN);
        }
        return (UserAuthDetails) principal;
    }
}
