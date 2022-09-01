package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectPhotoAlbums
 * @description 后台查询相册入参实体
 * @date 2022/8/31 10:34
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("后台查询相册入参实体")
public class SelectPhotoAlbums extends PagePropertyVo {

    @ApiModelProperty("相册名称")
    private String albumName;

}
