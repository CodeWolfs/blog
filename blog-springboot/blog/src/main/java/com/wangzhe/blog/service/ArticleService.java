package com.wangzhe.blog.service;

import com.wangzhe.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
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
    void selectArticlesAdmin(SelectArticlesVo selectArticlesVo);

}
