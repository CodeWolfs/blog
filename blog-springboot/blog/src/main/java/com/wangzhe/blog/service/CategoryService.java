package com.wangzhe.blog.service;

import com.wangzhe.blog.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
public interface CategoryService extends IService<Category> {
    /**
     * 保存标签（校验标签名是否存在
     */
    Integer saveCategory(String categoryName);

}
