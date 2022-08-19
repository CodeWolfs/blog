package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectMenusVo
 * @description
 * @date 2022/8/19 16:58
 */

@Data
@ApiModel("后台菜单列表查询条件实体")
public class SelectMenusVo {
    @ApiModelProperty("菜单名称")
    private String name;
}
