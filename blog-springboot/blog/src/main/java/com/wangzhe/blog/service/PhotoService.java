package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.PhotoAlbumViewDataDto;
import com.wangzhe.blog.entity.Photo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
public interface PhotoService extends IService<Photo> {

    /**
     * 后台添加照片
     */
    void insertPhotos(InsertPhotoVo insertPhotoVo);

    /**
     * 后台更新照片信息
     */
    void updatePhoto(UpdatePhotoVo updatePhotoVo);

    /**
     * 后台分页查询照片列表
     */
    Page<Photo> selectPhotosByAlbumId(SelectPhotosVo selectPhotosVo);

    /**
     * 后台查询相册视图数据
     */
    List<PhotoAlbumViewDataDto> selectPhotoAlbumViewData(Integer albumId);

    /**
     * 后台移动图片到指定相册
     */
    void movePhotoToAlbum(MovePhotoVo movePhotoVo);

    /**
     * 后台删除照片
     */
    void deletePhotos(DeletePhotosVo deletePhotosVo);
}
