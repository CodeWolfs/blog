package com.wangzhe.blog.vo;

import com.wangzhe.blog.common.validated.annotation.CustomerEmail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author WangZhe
 * @version 1.0
 * @className UserLoginVo
 * @description 用户登录信息
 * @date 2022/8/4 17:04
 */

@Data
@ApiModel("用户登录信息")
public class UserLoginVo {
    @ApiModelProperty(value = "用户名",required = true)
    @NotBlank(message = "用户名不能为空")
    @CustomerEmail
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    @NotBlank(message = "密码不能为空")
    private String password;
}
