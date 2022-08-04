package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 资源信息
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Getter
@Setter
@TableName("resource")
@ApiModel(value = "Resource对象", description = "资源信息")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("资源id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("资源名称")
    @TableField("resource_name")
    private String resourceName;

    @ApiModelProperty("资源路径")
    @TableField("uri")
    private String uri;

    @ApiModelProperty("请求方法")
    @TableField("request_method")
    private String requestMethod;

    @ApiModelProperty("父模块id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty("是否允许匿名访问0否，1是")
    @TableField("is_anonymous")
    private String isAnonymous;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}
