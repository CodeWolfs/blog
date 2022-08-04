package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectCount;
import com.wangzhe.blog.common.result.ResultCode;
import com.wangzhe.blog.entity.UserAuth;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.UserAuthMapper;
import com.wangzhe.blog.service.UserAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.UserRegisterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户认证信息 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthMapper, UserAuth> implements UserAuthService {
    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRegisterVo userRegisterVo) {
        LambdaQueryWrapper<UserAuth> userAuthLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userAuthLambdaQueryWrapper.eq(UserAuth::getUsername,userRegisterVo.getUsername());
        Long aLong = userAuthMapper.selectCount(userAuthLambdaQueryWrapper);
        if(aLong > 0) {
            throw new BizException(ResultCode.USERNAME_EXIST);
        }
        UserAuth userAuth = new UserAuth();
        BeanUtils.copyProperties(userRegisterVo,userAuth);
        String encode = passwordEncoder.encode(userAuth.getPassword());
        userAuth.setPassword(encode);
        userAuthMapper.insert(userAuth);
    }
}
