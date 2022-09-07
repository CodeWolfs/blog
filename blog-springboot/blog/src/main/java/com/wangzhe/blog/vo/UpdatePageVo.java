package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdatePageVo
 * @description
 * @date 2022/9/7 10:51
 */

@Data
@ApiModel("后台更新页面入参实体")
public class UpdatePageVo {

    @ApiModelProperty(value = "页面id",required = true)
    @NotNull(message = "页面id不能为空")
    private Integer id;

    @ApiModelProperty(value = "页面名称",required = true)
    @NotNull(message = "页面名称不能为空")
    private String pageName;

    @ApiModelProperty(value = "页面标签",required = true)
    @NotNull(message = "页面标签不能为空")
    private String pageLabel;

    @ApiModelProperty(value = "页面封面",required = true)
    @NotNull(message = "页面封面不能为空")
    private String pageCover;

}
