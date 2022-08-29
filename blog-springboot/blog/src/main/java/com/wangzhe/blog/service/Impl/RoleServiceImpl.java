package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.RoleDto;
import com.wangzhe.blog.dto.RoleMenuDto;
import com.wangzhe.blog.dto.RoleResourceDto;
import com.wangzhe.blog.entity.Role;
import com.wangzhe.blog.entity.RoleMenuRelation;
import com.wangzhe.blog.entity.RoleResourceRelation;
import com.wangzhe.blog.entity.UserRoleRelation;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.MenuMapper;
import com.wangzhe.blog.mapper.ResourceMapper;
import com.wangzhe.blog.mapper.RoleMapper;
import com.wangzhe.blog.security.SecurityMetadataSourceImpl;
import com.wangzhe.blog.service.RoleMenuRelationService;
import com.wangzhe.blog.service.RoleResourceRelationService;
import com.wangzhe.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.service.UserRoleRelationService;
import com.wangzhe.blog.vo.DeleteRolesVo;
import com.wangzhe.blog.vo.RoleVo;
import com.wangzhe.blog.vo.SelectRolesVo;
import com.wangzhe.blog.vo.UpdateRoleVo;
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

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private SecurityMetadataSourceImpl securityMetadataSource;

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @Override
    public Page<Role> selectRoles(SelectRolesVo selectRolesVo) {
        Page<Role> rolePage = new Page<>(selectRolesVo.getPageNum(), selectRolesVo.getPageSize());
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (BeanUtil.isNotEmpty(selectRolesVo.getRoleName())) {
            roleLambdaQueryWrapper.like(Role::getRoleName, selectRolesVo.getRoleName());
        }
        rolePage = this.page(rolePage, roleLambdaQueryWrapper);
        return rolePage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertRole(RoleVo roleVo) {
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper.eq(Role::getRoleName, roleVo.getRoleName());
        Role roleNameOne = this.getOne(roleLambdaQueryWrapper);
        if (roleNameOne != null) {
            throw new BizException("角色名存在");
        }
        roleLambdaQueryWrapper.clear();
        roleLambdaQueryWrapper.eq(Role::getRoleLabel, roleVo.getRoleLabel());
        Role roleLabelOne = this.getOne(roleLambdaQueryWrapper);
        if (roleLabelOne != null) {
            throw new BizException("角色标签存在");
        }

        Role role = new Role();
        BeanUtil.copyProperties(roleVo, role);
        this.save(role);
        //处理菜单 和资源
        this.insertMenuAndResourceForRoleId(role.getId(),roleVo.getMenuIdList(),roleVo.getResourceIdList());
        //系统权限重新加载资源
        securityMetadataSource.clearDataSource();


    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRoleByPrimaryKey(UpdateRoleVo updateRoleVo) {
        Role byId = getById(updateRoleVo.getId());
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper.eq(Role::getRoleName, updateRoleVo.getRoleName()).ne(Role::getRoleName, byId.getRoleName());
        long roleNameCount = this.count(roleLambdaQueryWrapper);
        if (roleNameCount > 0) {
            throw new BizException("角色名存在");
        }
        roleLambdaQueryWrapper.clear();
        roleLambdaQueryWrapper.eq(Role::getRoleLabel, updateRoleVo.getRoleLabel()).ne(Role::getRoleLabel, byId.getRoleLabel());
        long roleLabelCount = this.count(roleLambdaQueryWrapper);
        if (roleLabelCount > 0) {
            throw new BizException("角色标签存在");
        }
        BeanUtil.copyProperties(updateRoleVo,byId);
        this.updateById(byId);

        //更新 菜单和资源列表，先清空
        this.clearMenuAndResourceByRoleId(byId.getId());
        this.insertMenuAndResourceForRoleId(updateRoleVo.getId(),updateRoleVo.getMenuIdList(),updateRoleVo.getResourceIdList());
        //系统权限重新加载资源
        securityMetadataSource.clearDataSource();
    }

    /**
     * 清空角色菜单和资源关系
     *
     * @param roleId 角色id
     */
    private void clearMenuAndResourceByRoleId(Integer roleId) {
        LambdaQueryWrapper<RoleMenuRelation> roleMenuRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleMenuRelationLambdaQueryWrapper.eq(RoleMenuRelation::getRoleId, roleId);
        roleMenuRelationService.remove(roleMenuRelationLambdaQueryWrapper);

        LambdaQueryWrapper<RoleResourceRelation> roleResourceRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleResourceRelationLambdaQueryWrapper.eq(RoleResourceRelation::getRoleId,roleId);
        roleResourceRelationService.remove(roleResourceRelationLambdaQueryWrapper);
    }

    /**
     * 添加角色，菜单，资源映射关系
     * @param roleId 角色id
     * @param menuIdList 菜单id列表
     * @param resourceIdList 资源id列表
     */
    private void insertMenuAndResourceForRoleId(Integer roleId, List<Integer> menuIdList, List<Integer> resourceIdList) {
        //处理菜单
        if (CollUtil.isNotEmpty(menuIdList)) {
            List<RoleMenuRelation> collect = menuIdList.stream().map(id -> {
                RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
                roleMenuRelation.setRoleId(roleId);
                roleMenuRelation.setMenuId(id);
                return roleMenuRelation;
            }).collect(Collectors.toList());
            roleMenuRelationService.saveBatch(collect);
        }
        //处理接口
        if (CollUtil.isNotEmpty(resourceIdList)) {
            List<RoleResourceRelation> collect = resourceIdList.stream().map(id -> {
                RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
                roleResourceRelation.setRoleId(roleId);
                roleResourceRelation.setResourceId(id);
                return roleResourceRelation;
            }).collect(Collectors.toList());
            roleResourceRelationService.saveBatch(collect);
        }

    }

    @Override
    public void updateRoleStatusByPrimaryKey(Integer roleId, String isDisable) {
        Role role = new Role();
        role.setId(roleId);
        role.setIsDisable(isDisable);
        this.updateById(role);
    }

    @Override
    public RoleDto selectRoleById(Integer roleId) {
        return roleMapper.selectRoleById(roleId);
    }

    @Override
    public List<RoleMenuDto> selectRoleMenu() {
        return menuMapper.selectRoleMenu();
    }

    @Override
    public List<RoleResourceDto> selectRoleResource() {
        return resourceMapper.selectRoleResource();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRoles(DeleteRolesVo deleteRolesVo) {
        LambdaQueryWrapper<UserRoleRelation> userRoleRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleRelationLambdaQueryWrapper.in(UserRoleRelation::getRoleId,deleteRolesVo.getRoleIdList());
        long count = userRoleRelationService.count(userRoleRelationLambdaQueryWrapper);
        if(count > 0) {
            throw new BizException("角色下有用户在使用");
        }
        this.removeBatchByIds(deleteRolesVo.getRoleIdList());
        //系统权限重新加载资源
        securityMetadataSource.clearDataSource();
    }
}


