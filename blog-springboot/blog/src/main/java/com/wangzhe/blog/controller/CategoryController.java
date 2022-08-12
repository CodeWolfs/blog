package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.entity.Category;
import com.wangzhe.blog.service.CategoryService;
import com.wangzhe.blog.vo.DeleteArticleListVo;
import com.wangzhe.blog.vo.SelectCategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Api(tags = "分类管理")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("查询分类列表")
    @GetMapping("/admin/categories")
    public Result<?> selectCategory(@Validated SelectCategoryVo selectCategoryVo) {
        Page<Category> categoryPage = categoryService.selectCategory(selectCategoryVo);
        return Result.ok(categoryPage);
    }

    @ApiOperation("查询分类详情")
    @ApiImplicitParam(name = "id", value = "分类id", dataTypeClass = Integer.class, paramType = "path",required = true)
    @GetMapping("/category/{id}")
    public Result<Category> selectCategoryByPrimaryKey(@Validated @NotNull(message = "分类id不能为空") @PathVariable("id") Integer id) {
        Category byId = categoryService.getById(id);
        return Result.ok(byId);
    }

    @ApiOperation("后台删除分裂")
    @ApiImplicitParam(name = "categoryIds", value = "分类id列表", dataTypeClass = List.class, paramType = "query",required = true)
    @DeleteMapping("/admin/categories")
    public Result<?> deleteCategories(@Validated @NotEmpty(message = "至少选中一条") List<Integer> categoryIds) {
        categoryService.deleteCategories(categoryIds);

        return Result.ok();
    }



}
