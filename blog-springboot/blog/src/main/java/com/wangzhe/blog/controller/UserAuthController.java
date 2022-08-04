package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.service.UserAuthService;
import com.wangzhe.blog.vo.EmailVo;
import com.wangzhe.blog.vo.UserLoginVo;
import com.wangzhe.blog.vo.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户认证信息 前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@RestController
@Api(tags = "用户认证管理")
@RequestMapping("/userAuth")
public class UserAuthController {
    @Autowired
    private UserAuthService authService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<?> register(@Validated @RequestBody UserRegisterVo userRegisterVo) {
        authService.register(userRegisterVo);
        return Result.ok();
    }

    @ApiOperation("发送注册验证码")
    @PostMapping("/sendRegisterMailCode")
    public Result<?> sendRegisterMailCode(@Validated EmailVo emailVo) {


        return Result.ok();
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<?> login(@Validated @RequestBody UserLoginVo userLoginVo) {

        return Result.ok();
    }

}
