package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateReviewStatusVo
 * @description 批量审核入参实体
 * @date 2022/8/17 14:59
 */

@ApiModel("批量审核入参实体")
@Data
public class UpdateReviewStatusVo {
    @ApiModelProperty(value = "评论id列表", required = true)
    @NotNull(message = "至少选中一条评论")
    private List<Integer> commentIds;

    @ApiModelProperty(value = "审核状态1:通过,2:不通过", required = true)
    @NotNull(message = "审核状态不能为空")
    private String reviewStatus;
}
