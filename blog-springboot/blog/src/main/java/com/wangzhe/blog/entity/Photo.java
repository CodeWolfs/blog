package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("photo")
@ApiModel(value = "Photo对象", description = "")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("照片id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("相册id")
    @TableField("album_id")
    private Integer albumId;

    @ApiModelProperty("照片名称")
    @TableField("photo_name")
    private String photoName;

    @ApiModelProperty("照片描述")
    @TableField("photo_desc")
    private String photoDesc;

    @ApiModelProperty("照片链接")
    @TableField("photo_src")
    private String photoSrc;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private String deleted;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
