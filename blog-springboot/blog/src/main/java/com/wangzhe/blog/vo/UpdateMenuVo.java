package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateMenuVo
 * @description 更新菜单参数实体
 * @date 2022/8/22 10:25
 */

@Data
@ApiModel("更新菜单参数实体")
public class UpdateMenuVo {

    @ApiModelProperty("菜单id")
    @NotNull(message = "菜单id不能为空")
    private Integer id;

    @ApiModelProperty("菜单名称")
    @NotBlank(message = "菜单名称不能为空")
    private String name;

    @ApiModelProperty("访问路径")
    @NotBlank(message = "访问路径不能为空")
    private String path;

    @ApiModelProperty("组件")
    @NotBlank(message = "组件不能为空")
    private String component;

    @ApiModelProperty("图标")
    @NotBlank(message = "图标不能为空")
    private String icon;

    @ApiModelProperty("排序")
    @NotNull(message = "排序不能为空")
    private Integer orderNum;

    @ApiModelProperty("父菜单id")
    private Integer parentId;

    @ApiModelProperty("是否隐藏0否，1是")
    @NotBlank(message = "是否隐藏不能为空")
    private String isHidden;
}
