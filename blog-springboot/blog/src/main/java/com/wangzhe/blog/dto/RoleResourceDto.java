package com.wangzhe.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className RoleResourceDto
 * @description 角色资源返参实体
 * @date 2022/8/29 8:58
 */
@Data
@ApiModel("角色资源返参实体")
public class RoleResourceDto {

    @ApiModelProperty("资源id")
    private Integer id;

    @ApiModelProperty("资源名称")
    private String label;

    @ApiModelProperty("子资源")
    private List<RoleMenuDto> children;


}
