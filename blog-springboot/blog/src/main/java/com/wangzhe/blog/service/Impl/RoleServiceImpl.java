package com.wangzhe.blog.service.Impl;

import com.wangzhe.blog.entity.Role;
import com.wangzhe.blog.mapper.RoleMapper;
import com.wangzhe.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
