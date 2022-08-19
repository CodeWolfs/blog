package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className DeleteCommentVo
 * @description
 * @date 2022/8/17 15:17
 */

@ApiModel("删除评论实体")
@Data
public class DeleteCommentVo {
    @ApiModelProperty(value = "评论id列表", required = true)
    @NotNull(message = "至少选中一条评论")
    private List<Integer> commentIds;

    @ApiModelProperty(value = "1：物理删除，0是逻辑删除", required = true)
    @NotNull(message = "删除状态不能为空")
    private String deleted;
}
