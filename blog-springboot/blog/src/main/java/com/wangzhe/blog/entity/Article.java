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
 * 文章表
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Getter
@Setter
@TableName("article")
@ApiModel(value = "Article对象", description = "文章表")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("作者id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("分类id")
    @TableField("category_id")
    private Integer categoryId;

    @ApiModelProperty("文章标题")
    @TableField("article_title")
    private String articleTitle;

    @ApiModelProperty("文章缩略图")
    @TableField("article_cover")
    private String articleCover;

    @ApiModelProperty("文章内容")
    @TableField("article_content")
    private String articleContent;

    @ApiModelProperty("文章类型")
    @TableField("article_type")
    private String articleType;

    @ApiModelProperty("原文链接")
    @TableField("origin_url")
    private String originUrl;

    @ApiModelProperty("置顶状态0否1是")
    @TableField("is_top")
    private String isTop;

    @ApiModelProperty("状态1公开，2私密，3草稿")
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
