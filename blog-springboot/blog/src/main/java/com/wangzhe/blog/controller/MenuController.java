package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.dto.MenuItemDto;
import com.wangzhe.blog.entity.Menu;
import com.wangzhe.blog.service.MenuService;
import com.wangzhe.blog.vo.InsertMenuVo;
import com.wangzhe.blog.vo.SelectMenusVo;
import com.wangzhe.blog.vo.UpdateMenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @GetMapping("/admin/menus")
    public Result<List<MenuDto>> selectMenus() {
        List<MenuDto> list = menuService.selectMenus();
        return Result.ok(list);
    }

    @ApiOperation("后台通过菜单名称查询菜单列表")
    @GetMapping("/admin/menus/condition")
    public Result<List<Menu>> selectMenusByCondition(@Validated SelectMenusVo selectMenusVo) {
        List<Menu> list = menuService.selectMenusByCondition(selectMenusVo);
        return Result.ok(list);
    }


    @ApiOperation("后台添加菜单")
    @PostMapping("/admin/menu")
    public Result<?> insertMenu(@Validated @RequestBody InsertMenuVo insertMenuVo) {
        menuService.insertMenu(insertMenuVo);
        return Result.ok();
    }

    @ApiOperation("后台查询菜单详情")
    @GetMapping("/admin/menu/{id}")
    @ApiImplicitParam(name = "id", value = "菜单id", dataTypeClass = Integer.class, paramType = "path",required = true)
    public Result<Menu> selectMenuByPrimaryKey(@Valid @NotNull(message = "菜单id不能为空") @PathVariable("id") Integer id) {
        Menu byId = menuService.getById(id);
        return Result.ok(byId);
    }

    @ApiOperation("后台修改菜单")
    @PatchMapping("/admin/menu")
    public Result<?> updateMenu(@Validated @RequestBody UpdateMenuVo updateMenuVo) {
        menuService.updateMenu(updateMenuVo);
        return Result.ok();
    }

    @ApiOperation("后台删除菜单")
    @DeleteMapping("/admin/menu/{id}")
    @ApiImplicitParam(name = "id", value = "菜单id", dataTypeClass = Integer.class, paramType = "path",required = true)
    public Result<?> deleteMenuByPrimaryKey(@Valid @NotNull(message = "菜单id不能为空") @PathVariable("id") Integer id) {
        menuService.deleteMenuByPrimaryKey(id);
        return Result.ok();
    }


}
