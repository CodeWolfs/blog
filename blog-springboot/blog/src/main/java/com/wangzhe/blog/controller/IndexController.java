package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangZhe
 * @version 1.0
 * @className IndexController
 * @description
 * @date 2022/8/3 10:21
 */

@RestController
public class IndexController {
    @GetMapping("/")
    public Result<?> index() {
        return Result.ok("index");
    }
}
