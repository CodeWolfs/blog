package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.entity.Page;
import com.wangzhe.blog.service.PageService;
import com.wangzhe.blog.vo.InsertPageVo;
import com.wangzhe.blog.vo.UpdatePageVo;
import com.wangzhe.blog.vo.WebInfoConfigVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-38-07
 */
@RestController
@Api(tags = "页面管理")
public class PageController {

    @Autowired
    private PageService pageService;

    @ApiOperation("后台保存页面")
    @PostMapping("/admin/page")
    public Result<?> insertPage(@Validated InsertPageVo insertPageVo) {
        pageService.insertPage(insertPageVo);
        return Result.ok();
    }

    @ApiOperation("后台更新页面")
    @PutMapping("/admin/page")
    public Result<?> updatePage(@Validated UpdatePageVo updatePageVo) {
        pageService.updatePage(updatePageVo);
        return Result.ok();
    }

    @ApiOperation("后台查询页面详情")
    @GetMapping("/admin/page/{id}")
    public Result<Page> selectPage(@Valid @PathVariable("id") Integer id) {
        Page byId = pageService.getById(id);
        return Result.ok(byId);
    }

    @ApiOperation("后台查询页面列表")
    @GetMapping("/admin/pages")
    public Result<List<Page>> selectPages() {
        List<Page> list = pageService.list();
        return Result.ok(list);
    }

    @ApiOperation("后台删除页面")
    @DeleteMapping("/admin/page/{id}")
    public Result<?> deletePage(@Valid @PathVariable("id") Integer id) {
        pageService.removeById(id);
        return Result.ok();
    }
}
