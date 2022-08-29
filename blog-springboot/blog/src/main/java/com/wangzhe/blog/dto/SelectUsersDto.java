package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectUsersDto
 * @description
 * @date 2022/8/29 10:47
 */

@Data
@ApiModel("后台查询用户返参实体")
public class SelectUsersDto {

    @ApiModelProperty("用户id")
    private Integer userInfoId;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("登录类型")
    private String loginType;

    @ApiModelProperty("角色列表")
    private List<UserRoleDto> roleList;

    @ApiModelProperty("是否禁用")
    private String isDisabled;

    @ApiModelProperty("登录ip")
    private String ipAddress;

    @ApiModelProperty("登录地址")
    private String ipSource;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("上一次登录时间")
    private LocalDateTime lastLoginTime;
}
@Data
class UserRoleDto {
    @ApiModelProperty("角色id")
    private Integer roleId;

    @ApiModelProperty("角色名称")
    private String roleName;
}