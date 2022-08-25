package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wz
 * @since 2022-02-25
 */
@Getter
@Setter
@TableName("role_menu_relation")
@ApiModel(value = "RoleMenuRelation对象", description = "")
public class RoleMenuRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色菜单关联id")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("菜单id")
    @TableField("menu_id")
    private Integer menuId;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
