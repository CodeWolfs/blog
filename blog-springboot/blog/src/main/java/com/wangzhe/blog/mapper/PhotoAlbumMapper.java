package com.wangzhe.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.PhotoAlbumDto;
import com.wangzhe.blog.entity.PhotoAlbum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangzhe.blog.vo.SelectPhotoAlbums;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
@Mapper
public interface PhotoAlbumMapper extends BaseMapper<PhotoAlbum> {


    /**
     * 物理删除相册
     */
    void deleteByIdForPhysics(@Param("id") Integer id);

    /**
     * 分页查询相册
     */
    Page<PhotoAlbumDto> selectPhotoAlbumsPage(@Param("page") Page<PhotoAlbumDto> photoAlbumPage, @Param("condition") SelectPhotoAlbums selectPhotoAlbums);

    /**
     * 查询相册详情
     */
    PhotoAlbumDto selectPhotoAlbum(@Param("id") Integer id);

}
