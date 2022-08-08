package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangZhe
 * @version 1.0
 * @className IndexController
 * @description
 * @date 2022/8/3 10:21
 */

@RestController
@Api(tags = "index测试模块")
@RequestMapping("/index")
public class IndexController {

    @PostMapping("test")
    @ApiOperation("post test")
    public Result<?> index() {
        System.out.println(123);
        return Result.ok();
    }

    @GetMapping("/test")
    @ApiOperation("get test")
    public Result<?> test() {
        return Result.ok();
    }

    @GetMapping("/error")
    @ApiOperation("get error")
    public Result<?> error() {
        return Result.ok();
    }
}
