package com.wangzhe.blog.service;

import com.wangzhe.blog.entity.UserAuth;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.EmailVo;
import com.wangzhe.blog.vo.UserLoginVo;
import com.wangzhe.blog.vo.UserRegisterVo;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 用户认证信息 服务类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
public interface UserAuthService extends IService<UserAuth> {

    /**
     * 用户注册
     */
    void register(UserRegisterVo userRegisterVo);

    /**
     * 发送注册邮箱验证码
     */
    void sendRegisterMailCode(EmailVo emailVo);

    /**
     * 系统账号登录
     */
    String login(UserLoginVo userLoginVo);

    /**
     * 通过用户名获取UserDetails
     *
     * @param username 用户名
     */
    UserDetails loadUserByUsername(String username);
}

