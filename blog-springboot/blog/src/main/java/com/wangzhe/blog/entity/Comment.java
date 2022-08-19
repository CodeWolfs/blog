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
 * @since 2022-49-17
 */
@Getter
@Setter
@TableName("comment")
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("评论用户Id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("评论主题id")
    @TableField("topic_id")
    private Integer topicId;

    @ApiModelProperty("评论内容")
    @TableField("comment_content")
    private String commentContent;

    @ApiModelProperty("回复用户id")
    @TableField("reply_user_id")
    private Integer replyUserId;

    @ApiModelProperty("父评论id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty("评论类型 1.文章 2.友链 3.说说")
    @TableField("type")
    private String type;

    @ApiModelProperty("是否删除  0否 1是")
    @TableField("deleted")
    @TableLogic
    private String deleted;

    @ApiModelProperty("是否审核 0待审核，1审核通过，2审核不通过")
    @TableField("review_status")
    private String reviewStatus;

    @ApiModelProperty("评论时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
