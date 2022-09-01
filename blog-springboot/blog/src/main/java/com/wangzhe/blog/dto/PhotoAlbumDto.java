package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className PhotoAlbumDto
 * @description 相册返参实体
 * @date 2022/9/1 16:32
 */

@Data
@ApiModel("相册返参实体")
public class PhotoAlbumDto {

    @ApiModelProperty("相册id")
    private Integer id;

    @ApiModelProperty("相册名称")
    private String albumName;

    @ApiModelProperty("相册描述")
    private String albumDesc;

    @ApiModelProperty("相册封面")
    private String albumCover;

    @ApiModelProperty("状态1公开2私密")
    private String status;

    @ApiModelProperty("逻辑删除")
    private String deleted;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
