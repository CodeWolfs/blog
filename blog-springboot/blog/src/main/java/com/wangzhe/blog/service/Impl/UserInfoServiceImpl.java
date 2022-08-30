package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectUserRolesDto;
import com.wangzhe.blog.dto.SelectUsersDto;
import com.wangzhe.blog.entity.Role;
import com.wangzhe.blog.entity.UserInfo;
import com.wangzhe.blog.entity.UserRoleRelation;
import com.wangzhe.blog.mapper.RoleMapper;
import com.wangzhe.blog.mapper.UserInfoMapper;
import com.wangzhe.blog.mapper.UserRoleRelationMapper;
import com.wangzhe.blog.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.service.UserRoleRelationService;
import com.wangzhe.blog.vo.InsertUserRoleVo;
import com.wangzhe.blog.vo.SelectUsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @Override
    public Page<SelectUsersDto> selectUsers(SelectUsersVo selectUsersVo) {
        Page<SelectUsersDto> selectUsersDtoPage = new Page<SelectUsersDto>(selectUsersVo.getPageNum(), selectUsersVo.getPageSize());
        selectUsersDtoPage = userInfoMapper.selectUsers(selectUsersDtoPage,selectUsersVo);
        return selectUsersDtoPage;
    }

    @Override
    public List<SelectUserRolesDto> selectRoles() {
        List<Role> roles = roleMapper.selectList(null);
        List<SelectUserRolesDto> collect = roles.stream().map(role -> {
            SelectUserRolesDto selectUserRolesDto = new SelectUserRolesDto();
            selectUserRolesDto.setRoleId(role.getId());
            selectUserRolesDto.setRoleName(role.getRoleName());
            return selectUserRolesDto;
        }).collect(Collectors.toList());
        return collect;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertUserRole(InsertUserRoleVo insertUserRoleVo) {
        //清除之前角色
        LambdaQueryWrapper<UserRoleRelation> userRoleRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleRelationLambdaQueryWrapper.eq(UserRoleRelation::getUserInfoId,insertUserRoleVo.getUserInfoId());
        userRoleRelationService.remove(userRoleRelationLambdaQueryWrapper);
        //添加角色
        List<UserRoleRelation> collect = insertUserRoleVo.getRoleIdList().stream().map(roleId -> {
            UserRoleRelation userRoleRelation = new UserRoleRelation();
            userRoleRelation.setUserInfoId(insertUserRoleVo.getUserInfoId());
            userRoleRelation.setRoleId(roleId);
            return userRoleRelation;
        }).collect(Collectors.toList());
        userRoleRelationService.saveBatch(collect);
    }
}
