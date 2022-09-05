package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className ResumePhotosVo
 * @description 后台恢复照片入参实体
 * @date 2022/8/31 11:20
 */

@Data
@ApiModel("后台恢复照片入参实体")
public class ResumePhotosVo {
    @ApiModelProperty(value = "照片id列表", required = true)
    @NotEmpty(message = "照片id列表不能为空")
    private List<Integer> photoIdList;
}
