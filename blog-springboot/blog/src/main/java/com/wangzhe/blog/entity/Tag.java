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
 * 标签表
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Getter
@Setter
@TableName("tag")
@ApiModel(value = "Tag对象", description = "标签表")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标签名称")
    @TableField("tag_name")
    private String tagName;


    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
