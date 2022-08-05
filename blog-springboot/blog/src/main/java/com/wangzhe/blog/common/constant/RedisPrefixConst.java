package com.wangzhe.blog.common.constant;

/**
 * @author WangZhe
 * @version 1.0
 * @className RedisPrefixConst
 * @description redis-key 前缀配置
 * @date 2022/8/5 8:58
 */

public class RedisPrefixConst {

    /**
     * 验证码过期时间
     */
    public static final long CODE_EXPIRE_TIME = 5 * 60;
    /**
     * 邮箱验证码
     */
    public static final String EMAIL_CODE = "email_code:";
}
