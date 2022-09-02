package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectPhotosVo
 * @description 后台查询相片入参实体
 * @date 2022/9/2 10:09
 */

@Data
@ApiModel("后台查询相片入参实体")
public class SelectPhotosVo extends PagePropertyVo{

    @ApiModelProperty(value = "相册id",required = true)
    @NotNull(message = "相册id不能为空")
    private Integer albumId;

    @ApiModelProperty(value = "照片名称")
    private String photoName;
}
