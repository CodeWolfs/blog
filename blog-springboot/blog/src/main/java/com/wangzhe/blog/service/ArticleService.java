package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectArticleDto;
import com.wangzhe.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.DeleteArticleListVo;
import com.wangzhe.blog.vo.SaveArticleVo;
import com.wangzhe.blog.vo.SelectArticlesVo;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
public interface ArticleService extends IService<Article> {

    /**
     * 发布文章
     */
    void saveArticle(SaveArticleVo saveArticleVo);

    /**
     * 后台查询文章
     */
    Page<SelectArticleDto> selectArticlesAdmin(SelectArticlesVo selectArticlesVo);

    /**
     * 后台删除文章
     */
    void deleteArticleList(DeleteArticleListVo deleteArticleListVo);

}
