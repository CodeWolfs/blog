package com.wangzhe.blog.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectRolesVo
 * @description 后台查询角色入参实体
 * @date 2022/8/23 14:32
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("后台查询角色入参实体")
public class SelectRolesVo extends PagePropertyVo{
    @ApiModelProperty("角色名称")
    private String roleName;
}
