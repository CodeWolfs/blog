package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className RoleVo
 * @description 添加角色入参实体
 * @date 2022/8/23 15:12
 */

@Data
@ApiModel("添加角色入参实体")
public class RoleVo {

    @ApiModelProperty(value = "角色名称", required = true)
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @ApiModelProperty(value = "角色标签", required = true)
    @NotBlank(message = "角色标签不能为空")
    private String roleLabel;

    @ApiModelProperty(value = "菜单id列表", required = true)
    private List<Integer> menuIdList;

    @ApiModelProperty(value = "资源id列表", required = true)
    private List<Integer> resourceIdList;

}
