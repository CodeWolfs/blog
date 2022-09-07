package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.service.UserAuthService;
import com.wangzhe.blog.vo.EmailVo;
import com.wangzhe.blog.vo.UpdateUserAuthVo;
import com.wangzhe.blog.vo.UserLoginVo;
import com.wangzhe.blog.vo.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<?> register(@Validated @RequestBody UserRegisterVo userRegisterVo) {
        authService.register(userRegisterVo);
        return Result.ok();
    }

    @ApiOperation("发送注册验证码")
    @PostMapping("/sendRegisterMailCode")
    public Result<?> sendRegisterMailCode(@Validated EmailVo emailVo) {
        authService.sendRegisterMailCode(emailVo);
        return Result.ok();
    }

    @ApiOperation("用户登录,返回token")
    @PostMapping("/login")
    public Result<?> login(@Validated @RequestBody UserLoginVo userLoginVo) {
        String token = authService.login(userLoginVo);
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        tokenMap.put("tokenHeader",tokenHeader);
        return Result.ok(tokenMap);
    }

    @ApiOperation("后台更新用户认证密码")
    @PatchMapping("/admin/userAuth/")
    public Result<?> updateUserAuth(@Validated UpdateUserAuthVo updateUserAuthVo) {
        authService.updateUserAuth(updateUserAuthVo);
        return Result.ok();
    }

}
