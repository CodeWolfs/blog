package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.entity.Role;
import com.wangzhe.blog.entity.RoleMenuRelation;
import com.wangzhe.blog.entity.RoleResourceRelation;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.RoleMapper;
import com.wangzhe.blog.service.RoleMenuRelationService;
import com.wangzhe.blog.service.RoleResourceRelationService;
import com.wangzhe.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.RoleVo;
import com.wangzhe.blog.vo.SelectRolesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private RoleMenuRelationService roleMenuRelationService;

    @Autowired
    private RoleResourceRelationService roleResourceRelationService;

    @Override
    public Page<Role> selectRoles(SelectRolesVo selectRolesVo) {
        Page<Role> rolePage = new Page<>(selectRolesVo.getPageNum(),selectRolesVo.getPageSize());
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(BeanUtil.isNotEmpty(selectRolesVo.getRoleName())) {
            roleLambdaQueryWrapper.like(Role::getRoleName,selectRolesVo.getRoleName());
        }
        rolePage = this.page(rolePage,roleLambdaQueryWrapper);
        return rolePage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertRole(RoleVo roleVo) {
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper.eq(Role::getRoleName,roleVo.getRoleName());
        Role roleNameOne = this.getOne(roleLambdaQueryWrapper);
        if(roleNameOne != null) {
            throw new BizException("角色名存在");
        }
        roleLambdaQueryWrapper.clear();
        roleLambdaQueryWrapper.eq(Role::getRoleLabel,roleVo.getRoleLabel());
        Role roleLabelOne = this.getOne(roleLambdaQueryWrapper);
        if(roleLabelOne != null) {
            throw new BizException("角色标签存在");
        }

        Role role = new Role();
        BeanUtil.copyProperties(roleVo,role);
        this.save(role);
        //处理菜单
        List<Integer> menuIdList = roleVo.getMenuIdList();
        if(CollUtil.isNotEmpty(menuIdList)) {
            List<RoleMenuRelation> collect = menuIdList.stream().map(id -> {
                RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
                roleMenuRelation.setRoleId(role.getId());
                roleMenuRelation.setMenuId(id);
                return roleMenuRelation;
            }).collect(Collectors.toList());
            roleMenuRelationService.saveBatch(collect);
        }
        //处理接口
        List<Integer> resourceIdList = roleVo.getResourceIdList();
        if(CollUtil.isNotEmpty(resourceIdList)) {
            List<RoleResourceRelation> collect = resourceIdList.stream().map(id -> {
                RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
                roleResourceRelation.setRoleId(role.getId());
                roleResourceRelation.setResourceId(id);
                return roleResourceRelation;
            }).collect(Collectors.toList());
            roleResourceRelationService.saveBatch(collect);
        }
    }
}
