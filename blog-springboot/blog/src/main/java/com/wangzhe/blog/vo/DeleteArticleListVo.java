package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className DeleteArticleListVo
 * @description
 * @date 2022/8/11 9:39
 */

@Data
@ApiModel("后台删除文章参数实体")
public class DeleteArticleListVo {
    @ApiModelProperty(value = "删除文章id数组",required = true)
    @NotEmpty
    private List<Integer> articleIdList;

    @ApiModelProperty(value = "删除类型标志位,0：逻辑删除，1物理删除",required = true)
    @NotBlank
    private String deleted;

}
