package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wz
 * @since 2022-21-01
 */
@Getter
@Setter
@TableName("china_holiday")
@ApiModel(value = "ChinaHoliday对象", description = "")
public class ChinaHoliday implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("日期: yyyy/MM/dd")
    @TableField("date")
    private String date;

    @ApiModelProperty("类型：0休息，1工作")
    @TableField("type")
    private String type;

    @ApiModelProperty("逻辑删除，0没有删除1：删除")
    @TableField("deleted")
    @TableLogic
    private String deleted;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
