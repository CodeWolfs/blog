package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.common.result.ResultCode;
import com.wangzhe.blog.dto.SelectArticleDto;
import com.wangzhe.blog.entity.*;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.ArticleMapper;
import com.wangzhe.blog.mapper.ArticleTagRelationMapper;
import com.wangzhe.blog.mapper.CategoryMapper;
import com.wangzhe.blog.mapper.TagMapper;
import com.wangzhe.blog.service.ArticleService;
import com.wangzhe.blog.service.ArticleTagRelationService;
import com.wangzhe.blog.service.CategoryService;
import com.wangzhe.blog.service.TagService;
import com.wangzhe.blog.utils.SecurityUtil;
import com.wangzhe.blog.vo.DeleteArticleListVo;
import com.wangzhe.blog.vo.SaveArticleVo;
import com.wangzhe.blog.vo.SelectArticlesVo;
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

    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private TagService tagService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveArticle(SaveArticleVo saveArticleVo) {
        Article article = new Article();
        BeanUtil.copyProperties(saveArticleVo, article);
        UserAuthDetails userDetails = SecurityUtil.getUserDetails();
        article.setUserId(userDetails.getUserInfo().getId());
        //处理分类
        Category category = categoryHandler(saveArticleVo.getCategoryName());
        article.setCategoryId(category.getId());
        //保存
        save(article);
        //处理tag
        List<Integer> tagIdList = tagHandler(saveArticleVo.getTagList());
        List<ArticleTagRelation> collect = tagIdList.stream().map(tagId -> {
            ArticleTagRelation articleTagRelation = new ArticleTagRelation();
            articleTagRelation.setTagId(tagId);
            articleTagRelation.setArticleId(article.getId());
            return articleTagRelation;
        }).collect(Collectors.toList());
        articleTagRelationService.saveBatch(collect);
    }

    /**
     * 保存tagNameList(保存不存在的）
     *
     * @param tagNameList 标签名列表
     * @return 返回所有的tagIdList
     */
    private List<Integer> tagHandler(List<String> tagNameList) {
        LambdaQueryWrapper<Tag> tagLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tagLambdaQueryWrapper.in(Tag::getTagName, tagNameList);
        List<Tag> existTagList = tagMapper.selectList(tagLambdaQueryWrapper);
        List<String> existTagNameList = existTagList.stream().map(Tag::getTagName).collect(Collectors.toList());
        List<Integer> existTagIdList = existTagList.stream().map(Tag::getId).collect(Collectors.toList());
        //保存不存在的tagName
        tagNameList.removeAll(existTagNameList);
        if (CollUtil.isNotEmpty(tagNameList)) {
            List<Tag> TagList = tagNameList.stream().map(tagName -> {
                Tag tag = new Tag();
                tag.setTagName(tagName);
                return tag;
            }).collect(Collectors.toList());
            tagService.saveBatch(TagList);
            List<Integer> collect = TagList.stream().map(Tag::getId).collect(Collectors.toList());
            existTagIdList.addAll(collect);
        }
        return existTagIdList;
    }

    /**
     * 保存文章处理分类
     */
    private Category categoryHandler(String categoryName) {
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getCategoryName, categoryName);
        Category category = categoryMapper.selectOne(categoryLambdaQueryWrapper);
        if (BeanUtil.isEmpty(category)) {
            category = new Category();
            category.setCategoryName(categoryName);
            categoryMapper.insert(category);
        }
        return category;
    }

    @Override
    public Page<SelectArticleDto> selectArticlesAdmin(SelectArticlesVo selectArticlesVo) {
        Page<SelectArticleDto> page = new Page<>(selectArticlesVo.getPageNum(), selectArticlesVo.getPageSize());
        Page<SelectArticleDto> articlePage = articleMapper.selectArticleListForAdminByCondition(page, selectArticlesVo);

        return articlePage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteArticleList(DeleteArticleListVo deleteArticleListVo) {
        if (deleteArticleListVo.getDeleted().equals("0")) {
            //逻辑删除
            this.removeBatchByIds(deleteArticleListVo.getArticleIdList());
        } else if(deleteArticleListVo.getDeleted().equals("1")) {
            //物理删除
            articleMapper.deleteBatchIds(deleteArticleListVo.getArticleIdList());

        } else {
            throw new BizException(ResultCode.VALID_ERROR);
        }
    }
}
