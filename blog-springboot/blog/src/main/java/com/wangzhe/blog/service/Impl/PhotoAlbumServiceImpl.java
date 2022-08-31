package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.wangzhe.blog.entity.PhotoAlbum;
import com.wangzhe.blog.mapper.PhotoAlbumMapper;
import com.wangzhe.blog.service.PhotoAlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.InsertPhotoAlbumVo;
import com.wangzhe.blog.vo.UpdatePhotoAlbumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
@Service
public class PhotoAlbumServiceImpl extends ServiceImpl<PhotoAlbumMapper, PhotoAlbum> implements PhotoAlbumService {

    @Autowired
    private PhotoAlbumMapper photoAlbumMapper;

    @Override
    public void insertPhotoAlbum(InsertPhotoAlbumVo insertPhotoAlbumVo) {
        PhotoAlbum photoAlbum = new PhotoAlbum();
        BeanUtil.copyProperties(insertPhotoAlbumVo,photoAlbum);
        this.save(photoAlbum);
    }

    @Override
    public void updatePhotoAlbum(UpdatePhotoAlbumVo updatePhotoAlbumVo) {
        PhotoAlbum photoAlbum = new PhotoAlbum();
        BeanUtil.copyProperties(updatePhotoAlbumVo,photoAlbum);
        this.updateById(photoAlbum);
    }

}
