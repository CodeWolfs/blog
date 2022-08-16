package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateTagVo
 * @description 标签更新参数实体
 * @date 2022/8/16 15:05
 */
@ApiModel("标签更新参数实体")
@Data
public class UpdateTagVo {
    @ApiModelProperty(value = "标签id", required = true)
    @NotNull(message = "标签id不能为空")
    private Integer id;

    @ApiModelProperty(value = "标签名称", required = true)
    @NotBlank(message = "标签名称不能为空")
    private String tagName;
}
