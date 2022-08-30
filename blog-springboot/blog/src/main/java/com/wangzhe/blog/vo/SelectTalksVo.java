package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectTalksVo
 * @description 后台查询说说入参实体
 * @date 2022/8/30 11:42
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("后台查询说说入参实体")
public class SelectTalksVo extends PagePropertyVo{

    @ApiModelProperty("状态 1公开，2私密，null是全部")
    private String status;

}
