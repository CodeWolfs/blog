package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.common.result.ResultCode;
import com.wangzhe.blog.entity.Article;
import com.wangzhe.blog.entity.Category;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.ArticleMapper;
import com.wangzhe.blog.mapper.CategoryMapper;
import com.wangzhe.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.SelectCategoryVo;
import com.wangzhe.blog.vo.UpdateCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Integer saveCategory(String categoryName) {
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getCategoryName, categoryName);
        Category one = getOne(categoryLambdaQueryWrapper);
        if (one == null) {
            Category category = new Category();
            category.setCategoryName(categoryName);
            this.save(category);
            return category.getId();
        } else {
            return one.getId();
        }
    }

    @Override
    public Page<Category> selectCategory(SelectCategoryVo selectCategoryVo) {
        Page<Category> categoryPage = new Page<>(selectCategoryVo.getPageNum(), selectCategoryVo.getPageSize());
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (BeanUtil.isNotEmpty(selectCategoryVo.getCategoryName())) {
            categoryLambdaQueryWrapper.like(Category::getCategoryName, selectCategoryVo.getCategoryName());
        }
        categoryLambdaQueryWrapper.orderByDesc(Category::getCreateTime);
        categoryPage = categoryMapper.selectPage(categoryPage, categoryLambdaQueryWrapper);
        return categoryPage;
    }

    @Override
    public Result<?> deleteCategories(List<Integer> categoryIds) {
        LambdaQueryWrapper<Article> articleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        articleLambdaQueryWrapper.in(Article::getCategoryId,categoryIds);
        List<Article> articles = articleMapper.selectList(articleLambdaQueryWrapper);
        if (BeanUtil.isNotEmpty(articles)){
            Set<Integer> collect = articles.stream().map(Article::getCategoryId).collect(Collectors.toSet());
            List<Category> categories = categoryMapper.selectBatchIds(collect);
            return Result.fail(ResultCode.CATEGORY_USING,categories);
        }
        this.removeBatchByIds(categoryIds);
        return Result.ok();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateCategoryByPrimaryKey(UpdateCategoryVo updateCategoryVo) {
        Category category = new Category();
        BeanUtil.copyProperties(updateCategoryVo,category);
        this.updateById(category);
    }
}
