package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.RoleDto;
import com.wangzhe.blog.dto.RoleMenuDto;
import com.wangzhe.blog.dto.RoleResourceDto;
import com.wangzhe.blog.entity.Role;
import com.wangzhe.blog.service.RoleService;
import com.wangzhe.blog.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
    public Result<Page<Role>> selectRoles(@Validated SelectRolesVo selectRolesVo) {
        Page<Role> list = roleService.selectRoles(selectRolesVo);
        return Result.ok(list);
    }

    @ApiOperation("后台查询角色详情")
    @GetMapping("/admin/role/{id}")
    @ApiImplicitParam(name = "id", value = "角色id", dataTypeClass = Integer.class, paramType = "path", required = true)
    public Result<RoleDto> selectRole(@Valid @PathVariable("id") Integer roleId) {
        RoleDto roleDto = roleService.selectRoleById(roleId);
        return Result.ok(roleDto);
    }

    @ApiOperation("后台新增角色")
    @PostMapping("/admin/role")
    public Result<?> insertRole(@Validated @RequestBody RoleVo roleVo) {
        roleService.insertRole(roleVo);
        return Result.ok();
    }

    @ApiOperation("后台更新角色")
    @PutMapping("/admin/role")
    public Result<?> updateRoleByPrimaryKey(@Validated @RequestBody UpdateRoleVo updateRoleVo) {
        roleService.updateRoleByPrimaryKey(updateRoleVo);
        return Result.ok();
    }

    @ApiOperation("后台更新角色状态")
    @PatchMapping("/admin/role/{id}")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "角色id", dataTypeClass = Integer.class, paramType = "path", required = true),
            @ApiImplicitParam(name = "isDisable", value = "角色状态0开放，1禁用", dataTypeClass = String.class, paramType = "query", required = true)
    })
    public Result<?> updateRoleStatusByPrimaryKey(@PathVariable("id") Integer roleId,@Valid @NotBlank(message = "角色状态不能为空") String isDisable) {
        roleService.updateRoleStatusByPrimaryKey(roleId,isDisable);
        return Result.ok();
    }

    @ApiOperation("后台查询角色菜单列表视图数据")
    @GetMapping("/admin/role/menus")
    public Result<?> selectRoleMenu() {
        List<RoleMenuDto> menuDtoList = roleService.selectRoleMenu();
        return Result.ok(menuDtoList);
    }

    @ApiOperation("后台查询角色资源列表视图数据")
    @GetMapping("/admin/role/resources")
    public Result<List<RoleResourceDto>> selectRoleResource() {
        List<RoleResourceDto> roleResourceDtoList = roleService.selectRoleResource();
        return Result.ok(roleResourceDtoList);
    }

    @ApiOperation("后台删除角色")
    @DeleteMapping("/admin/roles")
    public Result<List<RoleResourceDto>> deleteRoles(@Validated DeleteRolesVo deleteRolesVo) {
        roleService.deleteRoles(deleteRolesVo);
        return Result.ok();
    }



}
