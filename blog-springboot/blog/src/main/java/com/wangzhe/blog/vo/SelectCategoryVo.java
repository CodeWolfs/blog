package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectCategoryVo
 * @description 分类列表查询实体
 * @date 2022/8/12 16:34
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("分类列表查询实体")
@Data
public class SelectCategoryVo extends PagePropertyVo{
    @ApiModelProperty(value = "分类名称",required = true)
    private String categoryName;
}
