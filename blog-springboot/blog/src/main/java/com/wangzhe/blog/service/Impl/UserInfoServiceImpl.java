package com.wangzhe.blog.service.Impl;

import com.wangzhe.blog.entity.UserInfo;
import com.wangzhe.blog.mapper.UserInfoMapper;
import com.wangzhe.blog.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户详细信息 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
