package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectUsersDto;
import com.wangzhe.blog.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.SelectUsersVo;

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
}
