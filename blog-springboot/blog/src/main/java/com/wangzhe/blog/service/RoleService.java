package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.RoleVo;
import com.wangzhe.blog.vo.SelectRolesVo;

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
}
