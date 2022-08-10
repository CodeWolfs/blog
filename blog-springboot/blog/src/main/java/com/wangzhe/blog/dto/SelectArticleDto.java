package com.wangzhe.blog.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className SelectArticleDto
 * @description
 * @date 2022/8/10 15:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectArticleDto {

    @ApiModelProperty("文章id")
    private Integer id;

    @ApiModelProperty("分类名称")
    private Integer categoryName;

    @ApiModelProperty("文章标题")
    private String articleTitle;

    @ApiModelProperty("文章缩略图")
    private String articleCover;

    @ApiModelProperty("置顶状态0否1是")
    private String isTop;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("标签列表")
    private List<String> tagNameList;

}
