package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.service.ArticleService;
import com.wangzhe.blog.vo.SaveArticleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Api(tags = "文章管理")
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation("发布文章")
    @PostMapping("/admin/article")
    public Result<?> saveArticle(@Validated @RequestBody SaveArticleVo saveArticleVo){
        articleService.saveArticle(saveArticleVo);
        return Result.ok();
    }

}
