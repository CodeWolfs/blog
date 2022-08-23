package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className InsertResourceVo
 * @description 添加资源实体
 * @date 2022/8/22 17:31
 */

@Data
@ApiModel("添加资源实体")
public class InsertResourceVo {

    @ApiModelProperty(value = "资源名称", required = true)
    @NotBlank(message = "资源名称不能为空")
    private String resourceName;

    @ApiModelProperty(value = "资源路径", required = true)
    private String uri;

    @ApiModelProperty(value = "请求方法", required = true)
    private String requestMethod;

    @ApiModelProperty(value ="父模块id")
    private Integer parentId;

    @ApiModelProperty(value ="是否允许匿名访问0否，1是", required = true)
    private String isAnonymous;


}
