package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateUserAuthVo
 * @description
 * @date 2022/9/7 11:20
 */

@Data
@ApiModel("后台更新用户密码入参实体")
public class UpdateUserAuthVo {
    @ApiModelProperty(value = "用户账号id",required = true)
    @NotNull(message = "用户账号id不能为空")
    private Integer id;

    @ApiModelProperty(value = "旧密码",required = true)
    @NotNull(message = "旧密码不能为空")
    private String oldPassword;

    @ApiModelProperty(value = "新密码",required = true)
    @NotNull(message = "新密码不能为空")
    private String newPassword;
}
