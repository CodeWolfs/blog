package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WangZhe
 * @version 1.0
 * @className InsertPhotoAlbum
 * @description 后台添加相册入参实体
 * @date 2022/8/31 9:35
 */

@Data
@ApiModel("后台添加相册入参实体")
public class InsertPhotoAlbumVo {



    @ApiModelProperty("相册名称")
    @NotBlank(message = "相册名称不能为空")
    private String albumName;

    @ApiModelProperty("相册描述")
    @NotBlank(message = "相册描述不能为空")
    private String albumDesc;

    @ApiModelProperty("相册封面")
    @NotBlank(message = "相册封面不能为空")
    private String albumCover;

    @ApiModelProperty("状态1公开2私密")
    @NotBlank(message = "相册状态不能为空")
    private String status;

}
