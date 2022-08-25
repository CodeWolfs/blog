package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateRoleVo
 * @description 更新角色入参实体
 * @date 2022/8/25 11:07
 */

@Data
@ApiModel("更新角色入参实体")
public class UpdateRoleVo {

    @ApiModelProperty(value = "角色id", required = true)
    @NotNull(message = "角色id不能为空")
    private String id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色标签")
    private String roleLabel;

    @ApiModelProperty(value = "是否禁用")
    private String isDisable;

    @ApiModelProperty(value = "菜单id列表")
    private List<Integer> menuIdList;

    @ApiModelProperty(value = "资源id列表")
    private List<Integer> resourceIdList;

}
