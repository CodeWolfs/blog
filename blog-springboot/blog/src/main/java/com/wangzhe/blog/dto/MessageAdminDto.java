package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className MessageAdminDto
 * @description
 * @date 2022/8/19 11:57
 */

@ApiModel("后台查询留言结果实体")
@Data
public class MessageAdminDto {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("用户名")
    private String nickname;

    @ApiModelProperty("留言内容")
    private String messageContent;

    @ApiModelProperty("用户ip")
    private String ipAddress;

    @ApiModelProperty("用户地址")
    private String ipSource;

    @ApiModelProperty("弹幕速度")
    private Boolean time;

    @ApiModelProperty("审核状态0：待审核1；审核通过3：审核不通过")
    private String reviewStatus;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("审核状态字典值")
    private String reviewStatusText;


}
