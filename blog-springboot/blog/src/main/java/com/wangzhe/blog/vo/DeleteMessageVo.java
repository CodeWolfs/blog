package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className DeleteMessageVo
 * @description 删除留言实体
 * @date 2022/8/19 15:36
 */

@Data
@ApiModel("删除留言实体")
public class DeleteMessageVo {
    @ApiModelProperty(value = "留言id列表", required = true)
    @NotNull(message = "至少选中一条留言")
    private List<Integer> messageIds;

    @ApiModelProperty(value = "1：物理删除，0是逻辑删除", required = true)
    @NotNull(message = "删除状态不能为空")
    private String deleted;
}
