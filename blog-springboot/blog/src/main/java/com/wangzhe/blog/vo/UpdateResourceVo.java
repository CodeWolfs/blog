package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateResourceVo
 * @description
 * @date 2022/8/22 17:35
 */

@Data
@ApiModel("更新资源实体")
public class UpdateResourceVo {
    @ApiModelProperty(value = "资源id", required = true)
    @NotNull(message = "资源id不能为空")
    private Integer id;

    @ApiModelProperty(value = "资源名称", required = true)
    @NotBlank(message = "资源名称不能为空")
    private String resourceName;

    @ApiModelProperty(value = "资源路径", required = true)
    @NotBlank(message = "资源路径不能为空")
    private String uri;

    @ApiModelProperty(value = "请求方法", required = true)
    @NotBlank(message = "请求方法不能为空")
    private String requestMethod;

    @ApiModelProperty(value ="父模块id")
    private Integer parentId;

    @ApiModelProperty(value ="是否允许匿名访问0否，1是", required = true)
    @NotBlank(message = "是否允许匿名访问不能为空")
    private String isAnonymous;
}
