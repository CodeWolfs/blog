package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.entity.Role;
import com.wangzhe.blog.service.RoleService;
import com.wangzhe.blog.vo.InsertResourceVo;
import com.wangzhe.blog.vo.RoleVo;
import com.wangzhe.blog.vo.SelectRolesVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户角色 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@RestController
@Api(tags = "角色管理")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation("后台查询角色列表")
    @GetMapping("/admin/roles")
    public Result<Page<Role>> selectRoles(@Validated @RequestBody SelectRolesVo selectRolesVo) {
        Page<Role> list = roleService.selectRoles(selectRolesVo);
        return Result.ok(list);
    }

    @ApiOperation("后台新增角色")
    @PostMapping("/admin/role")
    public Result<?> insertRole(@Validated @RequestBody RoleVo roleVo) {
        roleService.insertRole(roleVo);
        return Result.ok();
    }

}
