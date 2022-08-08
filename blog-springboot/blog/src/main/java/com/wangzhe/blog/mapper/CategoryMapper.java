package com.wangzhe.blog.mapper;

import com.wangzhe.blog.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 分类表 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
