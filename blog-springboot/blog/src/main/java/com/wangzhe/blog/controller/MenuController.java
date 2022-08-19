package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.service.MenuService;
import com.wangzhe.blog.vo.SelectMenusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-47-19
 */
@RestController
@Api(tags = "菜单管理")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ApiOperation("后台查询菜单列表")
    @GetMapping("/admin/Menus")
    public Result<?> selectMenus(SelectMenusVo selectMenusVo) {
        List<MenuDto> list = menuService.selectMenus(selectMenusVo);
        return Result.ok();
    }

    @ApiOperation("后台添加菜单")
    @PostMapping("/admin/Menu")
    public Result<?> insertMenu() {

        return Result.ok();
    }

    @ApiOperation("后台修改菜单")
    @PatchMapping("/admin/Menu")
    public Result<?> updateMenu() {

        return Result.ok();
    }

    @ApiOperation("后台删除菜单")
    @DeleteMapping("/admin/Menu/{id}")
    public Result<?> updateMenu(@PathVariable("id") Integer id) {

        return Result.ok();
    }


}
