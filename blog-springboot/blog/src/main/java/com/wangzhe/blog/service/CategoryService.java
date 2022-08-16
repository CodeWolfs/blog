package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.SelectCategoryVo;
import com.wangzhe.blog.vo.UpdateCategoryVo;

import java.util.List;

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

    /***
     * @author WangZhe
     * @description 查询标签列表
     * @Date 16:38 2022/8/12
     **/
    Page<Category> selectCategory(SelectCategoryVo selectCategoryVo);

    /**
     * 删除分类列表通过id列表
     */
    Result<?> deleteCategories(List<Integer> categoryIds);

    /**
     * 通过id更新分类
     */
    void updateCategoryByPrimaryKey(UpdateCategoryVo updateCategoryVo);

    /***
     * @author WangZhe
     * @description 创建分类
     * @Date 14:12 2022/8/16
     **/
    void insertCategory(String categoryName);
}
