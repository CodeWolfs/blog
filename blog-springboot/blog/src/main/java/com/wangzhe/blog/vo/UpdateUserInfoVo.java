package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateUserInfoVo
 * @description
 * @date 2022/9/7 11:04
 */

@Data
@ApiModel("后台更新用户信息入参")
public class UpdateUserInfoVo {

    @ApiModelProperty(value = "用户id",required = true)
    private String id;

    @ApiModelProperty("用户名")
    private String nickname;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("个人简介")
    private String intro;

    @ApiModelProperty("个人网站")
    private String website;

}
