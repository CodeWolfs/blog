package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.SelectUsersDto;
import com.wangzhe.blog.service.UserInfoService;
import com.wangzhe.blog.vo.InsertUserRoleVo;
import com.wangzhe.blog.vo.SelectUsersVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户详细信息 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@RestController
@Api(tags ="用户管理")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("后台查询用户列表")
    @GetMapping("/admin/users")
    public Result<Page<SelectUsersDto>> selectUsers(@Validated SelectUsersVo selectUsersVo) {
        Page<SelectUsersDto> selectUsersDtoPage = userInfoService.selectUsers(selectUsersVo);
        return Result.ok(selectUsersDtoPage);
    }

    @ApiOperation("后台用户添加角色")
    @PostMapping("/admin/user")
    public Result<?> insertUserRole(@Validated InsertUserRoleVo insertUserRoleVo) {


        return Result.ok();
    }

}
