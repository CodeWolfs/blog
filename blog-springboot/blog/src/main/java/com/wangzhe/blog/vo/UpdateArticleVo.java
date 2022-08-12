package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel("更新文章参数实体")
public class UpdateArticleVo {
    @ApiModelProperty(value = "文章id", required = true)
    @NotNull
    private Integer id;

    @ApiModelProperty(value = "分类名称", required = true)
    @NotNull
    private String categoryName;

    @ApiModelProperty(value = "文章标题", required = true)
    @NotBlank
    private String articleTitle;

    @ApiModelProperty(value = "文章缩略图", required = true)
    @NotBlank
    private String articleCover;

    @ApiModelProperty(value = "文章内容", required = true)
    @NotBlank
    private String articleContent;

    @ApiModelProperty(value = "文章类型", required = true)
    @NotBlank
    private String articleType;

    @ApiModelProperty(value = "原文链接", required = false)
    private String originUrl;

    @ApiModelProperty(value = "置顶状态0否1是", required = true)
    @NotBlank
    private String isTop;

    @ApiModelProperty(value = "状态1公开，2私密，3草稿", required = true)
    @NotBlank
    private String status;

    @ApiModelProperty(value = "标签名称列表", required = true)
    @NotEmpty
    private List<String> tagList;

}
