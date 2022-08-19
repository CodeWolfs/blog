package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateMessageReviewStatusVo
 * @description 更新留言审核状态实体
 * @date 2022/8/19 15:20
 */
@ApiModel("更新留言审核状态实体")
@Data
public class UpdateMessageReviewStatusVo {
    @ApiModelProperty(value = "留言id列表", required = true)
    @NotNull(message = "至少选中一条留言")
    private List<Integer> messageIds;

    @ApiModelProperty(value = "审核状态1:通过,2:不通过", required = true)
    @NotNull(message = "审核状态不能为空")
    private String reviewStatus;
}
