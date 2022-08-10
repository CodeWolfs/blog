package com.wangzhe.blog.mapper;

import com.wangzhe.blog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    List<String> selectTagNameByArticleId(@Param("articleId") Integer articleId);

}
