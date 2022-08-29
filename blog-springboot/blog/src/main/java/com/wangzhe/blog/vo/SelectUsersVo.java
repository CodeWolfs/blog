package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectUsersVo
 * @description
 * @date 2022/8/29 10:45
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("后台查询用户列表入参实体")
public class SelectUsersVo extends PagePropertyVo{
    @ApiModelProperty("登录类型")
    private String loginType;
    @ApiModelProperty("用户昵称")
    private String nickName;
}
