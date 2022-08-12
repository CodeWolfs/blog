package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.ArticleDetailDto;
import com.wangzhe.blog.dto.SelectArticleDto;
import com.wangzhe.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.DeleteArticleListVo;
import com.wangzhe.blog.vo.SaveArticleVo;
import com.wangzhe.blog.vo.SelectArticlesVo;
import com.wangzhe.blog.vo.UpdateArticleVo;

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

    /**
     * @author WangZhe
     * @description 后台更新文章
     * @Date 9:40 2022/8/12
     **/
    void updateArticleAdmin(UpdateArticleVo updateArticleVo);


    ArticleDetailDto selectArticleByPrimaryKey(Integer id);
}
