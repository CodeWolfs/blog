package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.entity.WebInfoConfig;
import com.wangzhe.blog.service.WebInfoConfigService;
import com.wangzhe.blog.vo.UpdateWebInfoConfigVo;
import com.wangzhe.blog.vo.WebInfoConfigVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-24-07
 */
@RestController
@Api(tags = "网站配置信息管理")
public class WebInfoConfigController {

    @Autowired
    private WebInfoConfigService webInfoConfigService;

    @ApiOperation("后台保存网站配置信息")
    @PostMapping("/admin/webInfoConfig")
    public Result<?> insertWebInfoConfig(@Validated WebInfoConfigVo webInfoConfigVo) {
        webInfoConfigService.insertWebInfoConfig(webInfoConfigVo);
        return Result.ok();
    }

    @ApiOperation("后台更新网站配置信息")
    @PutMapping("/admin/webInfoConfig")
    public Result<?> updateWebInfoConfig(@Validated UpdateWebInfoConfigVo updateWebInfoConfigVo) {
        webInfoConfigService.updateWebInfoConfig(updateWebInfoConfigVo);
        return Result.ok();
    }

    @ApiOperation("后台查询网站配置信息")
    @GetMapping("/admin/webInfoConfig")
    public Result<WebInfoConfig> selectWebInfoConfig() {
        WebInfoConfig byId = webInfoConfigService.getById(1);
        return Result.ok(byId);
    }

}
