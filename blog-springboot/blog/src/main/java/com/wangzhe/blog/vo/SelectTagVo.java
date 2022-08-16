package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectTagVo
 * @description 标签查询实体
 * @date 2022/8/16 14:46
 */


@ApiModel("标签查询条件实体")
@Data
public class SelectTagVo extends PagePropertyVo{
    @ApiModelProperty(value = "标签名称",required = false)
    private String tagName;
}
