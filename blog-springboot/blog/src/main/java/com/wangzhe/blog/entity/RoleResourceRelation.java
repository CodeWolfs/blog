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
 * 角色资源关系
 * </p>
 *
 * @author wz
 * @since 2022-31-05
 */
@Getter
@Setter
@TableName("role_resource_relation")
@ApiModel(value = "RoleResourceRelation对象", description = "角色资源关系")
public class RoleResourceRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色资源关系id")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("资源id")
    @TableField("resource_id")
    private Integer resourceId;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;



}
