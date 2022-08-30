package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className InsertUserRoleVo
 * @description 后台添加用户角色入参实体
 * @date 2022/8/29 14:17
 */

@Data
@ApiModel("后台添加用户角色入参实体")
public class InsertUserRoleVo {

    @ApiModelProperty(value = "用户id", required = true)
    private Integer userInfoId;

    @ApiModelProperty(value = "角色id列表", required = true)
    private List<Integer> roleIdList;

}
