package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectMessagesVo
 * @description
 * @date 2022/8/19 11:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("后台留言列表查询参数实体")
public class SelectMessagesVo extends PagePropertyVo{

    @ApiModelProperty("是否审核 0待审核，1审核通过，2审核不通过，null全部")
    private String reviewStatus;

    @ApiModelProperty("评论用户昵称")
    private String nickname;
}
