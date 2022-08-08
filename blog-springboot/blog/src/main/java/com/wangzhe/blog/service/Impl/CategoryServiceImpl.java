package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangzhe.blog.entity.Category;
import com.wangzhe.blog.mapper.CategoryMapper;
import com.wangzhe.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Integer saveCategory(String categoryName) {
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getCategoryName,categoryName);
        Category one = getOne(categoryLambdaQueryWrapper);
        if(one == null) {
            Category category = new Category();
            category.setCategoryName(categoryName);
            this.save(category);
            return category.getId();
        } else {
            return one.getId();
        }
    }
}
