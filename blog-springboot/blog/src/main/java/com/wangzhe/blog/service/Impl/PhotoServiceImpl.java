package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.PhotoAlbumViewDataDto;
import com.wangzhe.blog.entity.Photo;
import com.wangzhe.blog.entity.PhotoAlbum;
import com.wangzhe.blog.mapper.PhotoAlbumMapper;
import com.wangzhe.blog.mapper.PhotoMapper;
import com.wangzhe.blog.service.PhotoAlbumService;
import com.wangzhe.blog.service.PhotoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
@Service

public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private PhotoAlbumMapper photoAlbumMapper;

    @Autowired
    @Lazy(true)
    private PhotoAlbumService photoAlbumService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertPhotos(InsertPhotoVo insertPhotoVo) {
        List<Photo> collect = insertPhotoVo.getPhotoSrcList().stream().map(photoSrc -> {
            Photo photo = new Photo();
            photo.setPhotoSrc(photoSrc);
            photo.setPhotoName(IdUtil.simpleUUID());
            photo.setAlbumId(insertPhotoVo.getAlbumId());
            return photo;
        }).collect(Collectors.toList());
        this.saveBatch(collect);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updatePhoto(UpdatePhotoVo updatePhotoVo) {
        Photo photo = new Photo();
        BeanUtil.copyProperties(updatePhotoVo, photo);
        this.updateById(photo);
    }

    @Override
    public Page<Photo> selectPhotosByAlbumId(SelectPhotosVo selectPhotosVo) {
        Page<Photo> photoPage = new Page<>(selectPhotosVo.getPageNum(), selectPhotosVo.getPageSize());
        photoPage = photoMapper.selectPhotosByAlbumId(photoPage, selectPhotosVo);
        return photoPage;
    }

    @Override
    public List<PhotoAlbumViewDataDto> selectPhotoAlbumViewData(Integer albumId) {
        LambdaQueryWrapper<PhotoAlbum> photoAlbumLambdaQueryWrapper = new LambdaQueryWrapper<>();
        photoAlbumLambdaQueryWrapper.ne(PhotoAlbum::getId,albumId);
        List<PhotoAlbum> photoAlbumList = photoAlbumMapper.selectList(photoAlbumLambdaQueryWrapper);
        List<PhotoAlbumViewDataDto> collect = photoAlbumList.stream().map(photoAlbum -> {
            PhotoAlbumViewDataDto photoAlbumViewDataDto = new PhotoAlbumViewDataDto();
            BeanUtil.copyProperties(photoAlbum, photoAlbumViewDataDto);
            return photoAlbumViewDataDto;
        }).collect(Collectors.toList());
        return collect;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void movePhotoToAlbum(MovePhotoVo movePhotoVo) {
        List<Photo> collect = movePhotoVo.getPhotoIdList().stream().map(id -> {
            Photo photo = new Photo();
            photo.setId(id);
            photo.setAlbumId(movePhotoVo.getAlbumId());
            return photo;
        }).collect(Collectors.toList());
        this.updateBatchById(collect);
    }

    @Override
    public void deletePhotos(DeletePhotosVo deletePhotosVo) {
        String deleted = deletePhotosVo.getDeleted();
        if(deleted.equals("0")) {
            //逻辑删除
            this.removeBatchByIds(deletePhotosVo.getPhotoIdList());

        }else if(deleted.equals("1")) {
            //物理删除
            photoMapper.deletePhotoForPhysics(deletePhotosVo.getPhotoIdList());
        }
    }

    @Override
    public List<Photo> selectPhotosForRecycle() {
        return photoMapper.selectRecyclePhotos();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void resumePhotos(ResumePhotosVo resumePhotosVo) {
        // 找回照片后，需要回复逻辑删除的相册
/*        List<Photo> collect = resumePhotosVo.getPhotoIdList().stream().map(id -> {
            Photo photo = new Photo();
            photo.setId(id);
            photo.setDeleted("0");
            return photo;
        }).collect(Collectors.toList());*/
        photoMapper.updatePhotoDeleted(resumePhotosVo.getPhotoIdList(),"0");

        LambdaQueryWrapper<Photo> photoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        photoLambdaQueryWrapper.in(Photo::getId,resumePhotosVo.getPhotoIdList());
        List<Photo> list = this.list(photoLambdaQueryWrapper);
        Set<Integer> albumIds = list.stream().map(Photo::getAlbumId).collect(Collectors.toSet());
        photoAlbumMapper.updatePhotoAlbumDeleted(albumIds,"0");
    }
}
