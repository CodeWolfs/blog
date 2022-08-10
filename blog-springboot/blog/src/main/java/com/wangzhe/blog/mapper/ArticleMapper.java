package com.wangzhe.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectArticleDto;
import com.wangzhe.blog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangzhe.blog.vo.SelectArticlesVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

Page<SelectArticleDto> selectArticleListForAdminByCondition(@Param("page") Page<SelectArticleDto> page, @Param("condition")SelectArticlesVo selectArticlesVo);

}
