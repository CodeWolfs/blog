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
 * @className DeletePhotosVo
 * @description 后台批量删除照片入参实体
 * @date 2022/8/31 11:06
 */

@Data
@ApiModel("后台批量删除照片入参实体")
public class DeletePhotosVo {

    @ApiModelProperty(value = "照片id列表", required = true)
    @NotEmpty(message = "至少选中一个照片")
    private List<Integer> photoIdList;

    @ApiModelProperty(value = "删除类型0：逻辑删除1：物理删除", required = true)
    @NotBlank(message = "删除类型不能为空")
    private String deleted;

}
