package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.PhotoAlbumDto;
import com.wangzhe.blog.entity.Photo;
import com.wangzhe.blog.entity.PhotoAlbum;
import com.wangzhe.blog.mapper.PhotoAlbumMapper;
import com.wangzhe.blog.mapper.PhotoMapper;
import com.wangzhe.blog.service.PhotoAlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.service.PhotoService;
import com.wangzhe.blog.vo.InsertPhotoAlbumVo;
import com.wangzhe.blog.vo.SelectPhotoAlbums;
import com.wangzhe.blog.vo.UpdatePhotoAlbumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private PhotoService photoService;

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

    @Override
    public void deletePhotoAlbum(Integer id) {
        //判断如果相册下有照片逻辑删除，没有就物理删除
        List<Photo> photos = photoMapper.selectAllPhoto(id);
        if(CollUtil.isNotEmpty(photos)) {
            //逻辑删除
            this.removeById(id);
            //逻辑删除图片
            photoService.removeBatchByIds(photos);
        } else {
            //物理删除
            photoAlbumMapper.deleteByIdForPhysics(id);
        }
    }

    @Override
    public Page<PhotoAlbumDto> selectPhotoAlbums(SelectPhotoAlbums selectPhotoAlbums) {
        Page<PhotoAlbumDto> photoAlbumPage = new Page<>(selectPhotoAlbums.getPageNum(), selectPhotoAlbums.getPageSize());
        photoAlbumPage = photoAlbumMapper.selectPhotoAlbumsPage(photoAlbumPage,selectPhotoAlbums);
        return photoAlbumPage;
    }

    @Override
    public PhotoAlbumDto selectPhotoAlbum(Integer id) {
        PhotoAlbumDto photoAlbumDto = photoAlbumMapper.selectPhotoAlbum(id);
        return photoAlbumDto;
    }
}
