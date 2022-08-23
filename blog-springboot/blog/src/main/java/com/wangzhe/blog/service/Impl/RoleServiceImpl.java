package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.entity.Role;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.RoleMapper;
import com.wangzhe.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.RoleVo;
import com.wangzhe.blog.vo.SelectRolesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Page<Role> selectRoles(SelectRolesVo selectRolesVo) {
        Page<Role> rolePage = new Page<>(selectRolesVo.getPageNum(),selectRolesVo.getPageSize());
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper.like(Role::getRoleName,selectRolesVo.getRoleName());
        rolePage = this.page(rolePage,roleLambdaQueryWrapper);
        return rolePage;
    }

    @Override
    public void insertRole(RoleVo roleVo) {
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper.eq(Role::getRoleName,roleVo.getRoleName());
        Role roleNameOne = this.getOne(roleLambdaQueryWrapper);
        if(roleNameOne != null) {
            throw new BizException("");
        }
        roleLambdaQueryWrapper.clear();
        roleLambdaQueryWrapper.eq(Role::getRoleLabel,roleVo.getRoleLabel());
        Role roleLabelOne = this.getOne(roleLambdaQueryWrapper);



    }
}
