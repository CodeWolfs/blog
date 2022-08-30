package com.wangzhe.blog.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectUserRolesDto
 * @description
 * @date 2022/8/30 10:04
 */

@Data
@ApiModel("查询所有角色视图数据")
public class SelectUserRolesDto {
    @ApiModelProperty(value = "角色id")
    private Integer roleId;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
