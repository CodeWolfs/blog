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
@TableName("talk")
@ApiModel(value = "Talk对象", description = "")
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("说说id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("user_info_id")
    private Integer userInfoId;

    @ApiModelProperty("说说内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("是否制定0否1是")
    @TableField("is_top")
    private String isTop;

    @ApiModelProperty("1公开，2私密")
    @TableField("status")
    private String status;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private String deleted;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

}
