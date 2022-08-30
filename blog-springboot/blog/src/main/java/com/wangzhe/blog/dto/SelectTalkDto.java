package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectTalkDto
 * @description 后台查询说说返参实体
 * @date 2022/8/30 14:37
 */

@Data
@ApiModel("后台查询说说返参实体")
public class SelectTalkDto {

    @ApiModelProperty(value = "说说id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userInfoId;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "说说内容")
    private String content;

    @ApiModelProperty(value = "是否置顶0否1是")
    private String isTop;

    @ApiModelProperty(value = "1公开，2私密")
    private String status;

    @ApiModelProperty(value = "图片链接列表")
    private List<String> imageUrlList;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
