package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
@Getter
@Setter
@TableName("photo_album")
@ApiModel(value = "PhotoAlbum对象", description = "")
public class PhotoAlbum implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("相册id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("相册名称")
    @TableField("album_name")
    private String albumName;

    @ApiModelProperty("相册描述")
    @TableField("album_desc")
    private String albumDesc;

    @ApiModelProperty("相册封面")
    @TableField("album_cover")
    private String albumCover;

    @ApiModelProperty("状态1公开2私密")
    @TableField("status")
    private String status;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private String deleted;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
