package com.wangzhe.blog.mapper;

import com.wangzhe.blog.entity.Photo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
@Mapper
public interface PhotoMapper extends BaseMapper<Photo> {

    /**
     * 查询所有照片
     */
    List<Photo> selectAllPhoto(@Param("albumId") Integer albumId);

}
