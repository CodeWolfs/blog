package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

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
 * @since 2022-09-30
 */
@Getter
@Setter
@TableName("app_image_relation")
@ApiModel(value = "AppImageRelation对象", description = "")
public class AppImageRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("关联图片id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("关联应用id")
    @TableField("relation_id")
    private Integer relationId;

    @ApiModelProperty("图片链接")
    @TableField("image_url")
    private String imageUrl;

    @ApiModelProperty("应用类型，10说说")
    @TableField("apply_type")
    private String applyType;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
