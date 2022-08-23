package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className ResourceDto
 * @description
 * @date 2022/8/23 10:25
 */

@Data
@ApiModel("资源返回实体")
public class ResourceItemDto {

    @ApiModelProperty("资源id")
    private Integer id;

    @ApiModelProperty("资源名称")
    private String resourceName;

    @ApiModelProperty("资源路径")
    private String uri;

    @ApiModelProperty("请求方法")
    private String requestMethod;

    @ApiModelProperty("父模块id")
    private Integer parentId;

    @ApiModelProperty("是否允许匿名访问0否，1是")
    private String isAnonymous;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("模块资源列表")
    private List<ResourceItemDto> children;
}
