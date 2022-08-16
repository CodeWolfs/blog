package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.entity.Tag;
import com.wangzhe.blog.service.TagService;
import com.wangzhe.blog.vo.SelectTagVo;
import com.wangzhe.blog.vo.UpdateTagVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Api(tags = "标签管理")
@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation("查询标签列表")
    @GetMapping("/admin/tags")
    public Result<?> selectTags(@Validated SelectTagVo selectTagVo) {
        Page<Tag> tagPage = tagService.selectTag(selectTagVo);
        return Result.ok(tagPage);
    }

    @ApiOperation("查询标签详情")
    @ApiImplicitParam(name = "id", value = "标签id", dataTypeClass = Integer.class, paramType = "path", required = true)
    @GetMapping("/tag/{id}")
    public Result<Tag> selectCategoryByPrimaryKey(@Validated @NotNull(message = "标签id不能为空") @PathVariable("id") Integer id) {
        Tag byId = tagService.getById(id);
        return Result.ok(byId);
    }

    @ApiOperation("更新标签")
    @PatchMapping("/tag")
    public Result<?> updateTagByPrimaryKey(@Validated UpdateTagVo updateTagVo) {
        tagService.updateTagByPrimaryKey(updateTagVo);
        return Result.ok();
    }


    @ApiOperation("后台删除标签")
    @ApiImplicitParam(name = "tagIds", value = "标签id列表", allowMultiple = true, dataTypeClass = Integer.class, paramType = "query", required = true)
    @DeleteMapping("/admin/tags")
    public Result<?> deleteCategories(@Validated @NotEmpty(message = "至少选中一条") @RequestParam(value = "tagIds") List<Integer> tagIds) {
        return tagService.deleteTagByIds(tagIds);
    }

    @ApiOperation("后台新增标签")
    @PostMapping("/admin/tag")
    @ApiImplicitParam(name = "tagName", value = "标签名称", dataTypeClass = String.class, paramType = "body", required = true)
    public Result<?> insertCategory(@Validated @NotBlank(message = "标签名称不能为空") @RequestBody String tagName) {
        tagService.insertTag(tagName);
        return Result.ok();
    }

}
