package com.wangzhe.blog.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdatePhotoVo
 * @description 后台更新照片信息入参实体
 * @date 2022/8/31 10:55
 */

@Data
@ApiModel("后台更新照片信息入参实体")
public class UpdatePhotoVo {

    @ApiModelProperty(value = "照片id",required = true)
    @NotNull(message = "照片id不能为空")
    private Integer id;

    @ApiModelProperty(value = "相片名称",required = true)
    @NotBlank(message = "相片名称不能为空")
    private String photoName;

    @ApiModelProperty(value = "相片描述")
    private String photoDesc;
}
