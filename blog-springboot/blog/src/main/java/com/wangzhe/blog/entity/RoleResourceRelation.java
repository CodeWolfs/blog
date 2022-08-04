package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
 * @since 2022-22-04
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


}
