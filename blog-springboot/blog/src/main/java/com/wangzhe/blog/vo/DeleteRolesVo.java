package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className DeleteRolesVo
 * @description 删除角色入参实体
 * @date 2022/8/29 10:06
 */

@Data
@ApiModel("删除角色入参实体")
public class DeleteRolesVo {

    @ApiModelProperty(value = "角色id列表", required = true)
    @NotEmpty(message = "至少选中一个角色")
    private List<Integer> roleIdList;
}
