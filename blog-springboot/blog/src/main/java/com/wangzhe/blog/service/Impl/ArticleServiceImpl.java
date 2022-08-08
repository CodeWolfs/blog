package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.entity.Article;
import com.wangzhe.blog.entity.ArticleTagRelation;
import com.wangzhe.blog.entity.Category;
import com.wangzhe.blog.mapper.ArticleMapper;
import com.wangzhe.blog.mapper.ArticleTagRelationMapper;
import com.wangzhe.blog.mapper.CategoryMapper;
import com.wangzhe.blog.mapper.TagMapper;
import com.wangzhe.blog.service.ArticleService;
import com.wangzhe.blog.service.ArticleTagRelationService;
import com.wangzhe.blog.service.CategoryService;
import com.wangzhe.blog.vo.SaveArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleTagRelationMapper articleTagRelationMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleTagRelationService articleTagRelationService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveArticle(SaveArticleVo saveArticleVo) {
        Article article = new Article();
        BeanUtil.copyProperties(saveArticleVo, article);
        articleMapper.insert(article);
        //处理分类
        Integer integer = categoryService.saveCategory(saveArticleVo.getCategoryName());
        article.setCategoryId(integer);
        //保存
        save(article);
        List<Integer> tagIdList = tagHandler(saveArticleVo.getTagList());
        List<ArticleTagRelation> collect = tagIdList.stream().map(tagId -> {
            ArticleTagRelation articleTagRelation = new ArticleTagRelation();
            articleTagRelation.setTagId(tagId);
            articleTagRelation.setArticleId(article.getId());
            return articleTagRelation;
        }).collect(Collectors.toList());
        articleTagRelationService.saveBatch(collect);
    }

    private List<Integer> tagHandler(List<String> tagNameList) {

        return null;
    }
}
