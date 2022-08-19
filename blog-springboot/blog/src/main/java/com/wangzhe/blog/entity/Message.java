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
 * @since 2022-08-19
 */
@Getter
@Setter
@TableName("message")
@ApiModel(value = "Message对象", description = "")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("用户名")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("留言内容")
    @TableField("message_content")
    private String messageContent;

    @ApiModelProperty("用户ip")
    @TableField("ip_address")
    private String ipAddress;

    @ApiModelProperty("用户地址")
    @TableField("ip_source")
    private String ipSource;

    @ApiModelProperty("弹幕速度")
    @TableField("time")
    private Boolean time;

    @ApiModelProperty("审核状态0：待审核1；审核通过3：审核不通过")
    @TableField("review_status")
    private String reviewStatus;

    @ApiModelProperty("是否删除  0否 1是")
    @TableField("deleted")
    @TableLogic
    private String deleted;

    @ApiModelProperty("留言时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
