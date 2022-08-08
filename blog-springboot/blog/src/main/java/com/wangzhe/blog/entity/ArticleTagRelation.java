package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 文章标签映射表
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Getter
@Setter
@TableName("article_tag_relation")
@ApiModel(value = "ArticleTagRelation对象", description = "文章标签映射表")
public class ArticleTagRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章标签关联id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标签id")
    @TableField("tag_id")
    private Integer tagId;

    @ApiModelProperty("文章id")
    @TableField("article_id")
    private Integer articleId;


}
