package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.*;
import com.wangzhe.blog.entity.Category;
import com.wangzhe.blog.entity.Tag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className ArticleDetailDto
 * @description
 * @date 2022/8/12 10:42
 */

@Data
@ApiModel("文章详情实体")
public class ArticleDetailDto {
    @ApiModelProperty("文章id")
    private Integer id;

    @ApiModelProperty("作者id")
    private Integer userId;

    @ApiModelProperty("作者名称")
    private String authorName;

    @ApiModelProperty("分类")
    private Category category ;

    @ApiModelProperty("文章标题")
    private String articleTitle;

    @ApiModelProperty("文章缩略图")
    private String articleCover;

    @ApiModelProperty("文章内容")
    private String articleContent;

    @ApiModelProperty("文章类型")
    private String articleType;

    @ApiModelProperty("原文链接")
    private String originUrl;

    @ApiModelProperty("置顶状态0否1是")
    private String isTop;

    @ApiModelProperty("状态1公开，2私密，3草稿")
    private String status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("标签列表")
    private List<Tag> tagList;

    @ApiModelProperty("文章类型文本")
    private String articleTypeText;

    @ApiModelProperty("置顶状态文本")
    private String isTopText;

    @ApiModelProperty("状态1公开，2私密，3草稿 文本")
    private String statusText;
}
