package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className CommentForAdminVo
 * @description
 * @date 2022/8/17 11:35
 */

@ApiModel("后台查询评论实体")
@Data
public class CommentForAdminDto {

    @ApiModelProperty("评论id")
    private Integer id;

    @ApiModelProperty("评论用户头像")
    private String commentAvatar;

    @ApiModelProperty("评论用户名")
    private String commentNickName;

    @ApiModelProperty("回复人用户名,没有为无")
    private String replyNickName;

    @ApiModelProperty("文章标题,其他类型为无")
    private String articleTitle;

    @ApiModelProperty("评论内容")
    private String commentContent;

    @ApiModelProperty("评论时间")
    private LocalDateTime createTime;

    @ApiModelProperty("审核状态 0待审核，1审核通过，2审核不通过")
    private String reviewStatus;

    @ApiModelProperty("评论类型 1.文章 2.友链 3.说说")
    private String typeText;




}
