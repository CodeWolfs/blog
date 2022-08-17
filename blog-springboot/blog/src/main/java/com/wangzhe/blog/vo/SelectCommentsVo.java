package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectCommentsVo
 * @description 查询评论实体
 * @date 2022/8/17 10:58
 */

@EqualsAndHashCode(callSuper = true)
@ApiModel("查询评论实体")
@Data
public class SelectCommentsVo extends PagePropertyVo{


    @ApiModelProperty("是否审核 0待审核，1审核通过，2审核不通过，null全部")
    private String reviewStatus;

    @ApiModelProperty("评论类型 1.文章 2.友链 3.说说")
    private String type;

    @ApiModelProperty("评论用户名")
    private String nickname;

}
