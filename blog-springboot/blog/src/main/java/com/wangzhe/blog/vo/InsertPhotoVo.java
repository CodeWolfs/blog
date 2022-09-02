package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className InsertPhotoVo
 * @description 后台添加照片入参实体
 * @date 2022/8/31 10:50
 */

@Data
@ApiModel("后台添加照片入参实体")
public class InsertPhotoVo {

    @ApiModelProperty(value = "上传相片链接列表",required = true)
    @NotEmpty(message = "相片链接列表不能为空")
    private List<String> PhotoSrcList;

    @ApiModelProperty(value = "相册id",required = true)
    @NotNull(message = "相册id不能为空")
    private Integer albumId;



}
