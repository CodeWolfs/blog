package com.wangzhe.blog.service;

import com.wangzhe.blog.entity.UserAuth;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.UserRegisterVo;

/**
 * <p>
 * 用户认证信息 服务类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
public interface UserAuthService extends IService<UserAuth> {

    void register(UserRegisterVo userRegisterVo);

}
