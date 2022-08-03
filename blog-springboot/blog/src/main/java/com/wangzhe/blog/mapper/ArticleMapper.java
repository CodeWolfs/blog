package com.wangzhe.blog.mapper;

import com.wangzhe.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 博客文章 Mapper 接口
 * </p>
 *
 * @author WZ
 * @since 2022-52-03
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
