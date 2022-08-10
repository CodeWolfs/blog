package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangZhe
 * @version 1.0
 * @className PagePropertyVo
 * @description
 * @date 2022/8/10 15:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagePropertyVo {
    @ApiModelProperty("页数")
    public Integer pageNum = 1;
    @ApiModelProperty("页大小")
    public Integer pageSize = 10;
}
