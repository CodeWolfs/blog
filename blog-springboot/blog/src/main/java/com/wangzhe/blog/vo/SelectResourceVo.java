package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectResourceVo
 * @description
 * @date 2022/8/23 10:31
 */

@Data
@ApiModel("资源查询条件实体")
public class SelectResourceVo {
    @ApiModelProperty("资源名称")
    private String resourceName;
}
