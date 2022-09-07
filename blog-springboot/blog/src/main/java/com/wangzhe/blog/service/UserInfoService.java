package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectUserRolesDto;
import com.wangzhe.blog.dto.SelectUsersDto;
import com.wangzhe.blog.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.InsertUserRoleVo;
import com.wangzhe.blog.vo.SelectUsersVo;
import com.wangzhe.blog.vo.UpdateUserInfoVo;

import java.util.List;

/**
 * <p>
 * 用户详细信息 服务类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 后台查询用户列表
     */
    Page<SelectUsersDto> selectUsers(SelectUsersVo selectUsersVo);

    /**
     * 后台查询所有角色列表视图数据
     */
    List<SelectUserRolesDto> selectRoles();

    /**
     * 后台添加用户角色
     */
    void insertUserRole(InsertUserRoleVo insertUserRoleVo);

    /**
     * 后台更新用户信息
     */
    void updateUserInfo(UpdateUserInfoVo updateUserInfoVo);
}
