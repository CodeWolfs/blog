package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className RegisterVo
 * @description 用户注册信息
 * @date 2022/8/4 16:55
 */

@Data
@ApiModel("用户注册信息")
public class UserRegisterVo {

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    @NotNull
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    @NotNull
    private String password;

}
