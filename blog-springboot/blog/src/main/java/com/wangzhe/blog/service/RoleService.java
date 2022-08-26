package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.RoleDto;
import com.wangzhe.blog.dto.RoleMenuDto;
import com.wangzhe.blog.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.RoleVo;
import com.wangzhe.blog.vo.SelectRolesVo;
import com.wangzhe.blog.vo.UpdateRoleVo;

import java.util.List;

/**
 * <p>
 * 用户角色 服务类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
public interface RoleService extends IService<Role> {
    /**
     * 后台查询角色列表
     */
    Page<Role> selectRoles(SelectRolesVo selectRolesVo);

    /**
     * 后台添加角色
     */
    void insertRole(RoleVo roleVo);

    /**
     * 后台更新角色
     */
    void updateRoleByPrimaryKey(UpdateRoleVo updateRoleVo);

    /**
     * 更新角色状态
     * @param roleId 角色id
     * @param isDisable 角色状态
     */
    void updateRoleStatusByPrimaryKey(Integer roleId, String isDisable);

    /**
     * 查询角色详情
     * @param roleId 角色id
     */
    RoleDto selectRoleById(Integer roleId);

    /**
     * 后台查询角色菜单列表视图数据
     * @return
     */
    List<RoleMenuDto> selectRoleMenu();
}
