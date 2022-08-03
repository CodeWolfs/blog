package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 博客文章
 * </p>
 *
 * @author WZ
 * @since 2022-52-03
 */
@Getter
@Setter
@TableName("tb_article")
@ApiModel(value = "Article对象", description = "博客文章")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("作者")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("文章分类")
    @TableField("category_id")
    private Integer categoryId;

    @ApiModelProperty("文章缩略图")
    @TableField("article_cover")
    private String articleCover;

    @ApiModelProperty("标题")
    @TableField("article_title")
    private String articleTitle;

    @ApiModelProperty("内容")
    @TableField("article_content")
    private String articleContent;

    @ApiModelProperty("文章类型 1原创 2转载 3翻译")
    @TableField("type")
    private Boolean type;

    @ApiModelProperty("原文链接")
    @TableField("original_url")
    private String originalUrl;

    @ApiModelProperty("是否置顶 0否 1是")
    @TableField("is_top")
    private Boolean isTop;

    @ApiModelProperty("是否删除  0否 1是")
    @TableField("is_delete")
    private Boolean isDelete;

    @ApiModelProperty("状态值 1公开 2私密 3评论可见")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("发表时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
