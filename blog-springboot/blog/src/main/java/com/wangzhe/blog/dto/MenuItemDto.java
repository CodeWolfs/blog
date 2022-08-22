package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className MenuItemDto
 * @description 菜单项实体
 * @date 2022/8/22 15:12
 */

@Data
@ApiModel("菜单项实体")
public class MenuItemDto {

    @ApiModelProperty("菜单id")
    private Integer id;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("访问路径")
    private String path;

    @ApiModelProperty("组件")
    private String component;

    @ApiModelProperty("图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("排序")
    private Integer orderNum;

    @ApiModelProperty("是否隐藏0否，1是")
    private String isHidden;

}
