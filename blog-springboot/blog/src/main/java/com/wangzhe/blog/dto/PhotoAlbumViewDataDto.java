package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhe
 * @version 1.0
 * @className PhotoAlbumViewDataDto
 * @description
 * @date 2022/9/2 10:41
 */

@Data
@ApiModel("后台查询相册视图数据")
public class PhotoAlbumViewDataDto {
    @ApiModelProperty("相册id")
    private Integer id;

    @ApiModelProperty("相册名称")
    private String albumName;
}
