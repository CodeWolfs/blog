package com.wangzhe.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className RoleMenuDto
 * @description 后台角色菜单列表视图数据实体
 * @date 2022/8/26 17:04
 */

@Data
@ApiModel("后台角色菜单列表视图数据实体")
public class RoleMenuDto {

    @ApiModelProperty("菜单id")
    private Integer id;

    @ApiModelProperty("菜单名称")
    private String label;

    @ApiModelProperty("子菜单")
    private List<RoleMenuDto> children;


}
