package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.entity.Menu;
import com.wangzhe.blog.entity.Resource;
import com.wangzhe.blog.service.MenuService;
import com.wangzhe.blog.service.ResourceService;
import com.wangzhe.blog.vo.*;
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
 * 资源信息 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@RestController
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @ApiOperation("后台查询资源列表")
    @GetMapping("/admin/resources")
    public Result<List<Resource>> selectResources() {
        List<Resource> list = resourceService.selectResources();
        return Result.ok(list);
    }

    @ApiOperation("后台添加资源")
    @PostMapping("/admin/resource")
    public Result<?> insertResource(@Validated @RequestBody InsertResourceVo insertResourceVo) {
        resourceService.insertResource(insertResourceVo);
        return Result.ok();
    }

    @ApiOperation("后台查询资源详情")
    @GetMapping("/admin/resource/{id}")
    @ApiImplicitParam(name = "id", value = "资源id", dataTypeClass = Integer.class, paramType = "path",required = true)
    public Result<Resource> selectResourceByPrimaryKey(@Valid @NotNull(message = "资源id不能为空") @PathVariable("id") Integer id) {
        Resource byId = resourceService.getById(id);
        return Result.ok(byId);
    }

    @ApiOperation("后台修改资源")
    @PatchMapping("/admin/resource")
    public Result<?> updateResource(@Validated @RequestBody UpdateResourceVo updateResourceVo) {
        resourceService.updateResource(updateResourceVo);
        return Result.ok();
    }

    @ApiOperation("后台删除资源")
    @DeleteMapping("/admin/resource/{id}")
    @ApiImplicitParam(name = "id", value = "资源id", dataTypeClass = Integer.class, paramType = "path",required = true)
    public Result<?> deleteResourceByPrimaryKey(@Valid @NotNull(message = "资源id不能为空") @PathVariable("id") Integer id) {
        resourceService.deleteResourceByPrimaryKey(id);
        return Result.ok();
    }
}
