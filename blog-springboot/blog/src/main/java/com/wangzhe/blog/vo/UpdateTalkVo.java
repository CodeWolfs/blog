package com.wangzhe.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className UpdateTalkVo
 * @description 后台更新说说入参实体
 * @date 2022/8/30 11:42
 */
@Data
@ApiModel("后台更新说说入参实体")
public class UpdateTalkVo {

    @ApiModelProperty(value = "说说id", required = true)
    @NotNull(message = "说说id不能为空")
    private Integer id;

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Integer userInfoId;

    @ApiModelProperty(value = "说说内容", required = true)
    @NotBlank(message = "说说内容不能为空")
    private String content;

    @ApiModelProperty(value = "是否置顶0否1是", required = true)
    @NotBlank(message = "是否置顶不能为空")
    private String isTop;

    @ApiModelProperty(value = "1公开，2私密", required = true)
    @NotBlank(message = "说说状态不能为空")
    private String status;

    @ApiModelProperty(value = "图片链接列表", required = true)
    private List<String> imageUrlList;
}
