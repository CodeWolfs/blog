package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className MenuDto
 * @description
 * @date 2022/8/19 17:09
 */
@Data
@ApiModel("后台菜单返回列表实体")
public class MenuDto {

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

    @ApiModelProperty("子菜单列表")
    private List<MenuDto> children;
}
