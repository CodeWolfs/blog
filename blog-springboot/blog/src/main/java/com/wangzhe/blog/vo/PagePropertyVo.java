package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "页数不能为空")
    public Integer pageNum = 1;
    @ApiModelProperty("页大小")
    @NotNull(message = "页大小不能为空")
    public Integer pageSize = 10;
}
