package com.wangzhe.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.PhotoAlbumDto;
import com.wangzhe.blog.entity.Photo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangzhe.blog.vo.SelectPhotosVo;
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


    /**
     * 后台分页查询相片
     */
    Page<Photo> selectPhotosByAlbumId(@Param("page") Page<Photo> photoPage, @Param("condition") SelectPhotosVo selectPhotosVo);

    /**
     * 后台物理删除相片
     */
    void deletePhotoForPhysics(@Param("photoIdList") List<Integer> photoIdList);
}
