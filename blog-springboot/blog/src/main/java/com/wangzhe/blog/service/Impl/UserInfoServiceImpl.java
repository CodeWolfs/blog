package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectUsersDto;
import com.wangzhe.blog.entity.UserInfo;
import com.wangzhe.blog.mapper.UserInfoMapper;
import com.wangzhe.blog.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.SelectUsersVo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Page<SelectUsersDto> selectUsers(SelectUsersVo selectUsersVo) {
        Page<SelectUsersDto> selectUsersDtoPage = new Page<SelectUsersDto>(selectUsersVo.getPageNum(), selectUsersVo.getPageSize());
        selectUsersDtoPage = userInfoMapper.selectUsers(selectUsersDtoPage,selectUsersVo);
        return selectUsersDtoPage;
    }
}
