package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectArticlesVo
 * @description 后台文章查询入参
 * @date 2022/8/9 9:37
 */

@EqualsAndHashCode(callSuper = true)
@ApiModel("后台文章查询入参")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectArticlesVo extends PagePropertyVo{

    @ApiModelProperty(value = "状态,1公开,2私密,3草稿箱")
    private String status;

    @ApiModelProperty(value = "回收站标记,1 回收站")
    private String deleted;

    @ApiModelProperty(value = "文章类型")
    private String articleType;

    @ApiModelProperty(value = "分类id")
    private Integer categoryId;

    @ApiModelProperty(value = "标签id")
    private Integer tagId;

    @ApiModelProperty(value = "文章标题")
    private String articleTitle;

}
