package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.PhotoAlbumDto;
import com.wangzhe.blog.entity.PhotoAlbum;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.InsertPhotoAlbumVo;
import com.wangzhe.blog.vo.SelectPhotoAlbums;
import com.wangzhe.blog.vo.UpdatePhotoAlbumVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
public interface PhotoAlbumService extends IService<PhotoAlbum> {

    /**
     * 后台添加相册
     */
    void insertPhotoAlbum(InsertPhotoAlbumVo insertPhotoAlbumVo);

    /**
     * 后台更新相册
     */
    void updatePhotoAlbum(UpdatePhotoAlbumVo updatePhotoAlbumVo);

    /**
     * 后台删除相册
     */
    void deletePhotoAlbum(Integer id);


    /**
     * 后台查询相册列表
     */
    Page<PhotoAlbumDto> selectPhotoAlbums(SelectPhotoAlbums selectPhotoAlbums);

    /**
     * 后台查询相册详情
     */
    PhotoAlbumDto selectPhotoAlbum(Integer id);
}
