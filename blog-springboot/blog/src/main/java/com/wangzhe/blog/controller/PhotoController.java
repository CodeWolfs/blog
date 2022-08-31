package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.service.PhotoService;
import com.wangzhe.blog.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
@RestController
@Api(tags = "照片管理")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @ApiOperation("后台上传照片")
    @PostMapping("/admin/photo/upload")
    public Result<?> uploadPhoto() {
        return Result.ok();
    }

    @ApiOperation("后台添加照片")
    @PostMapping("/admin/photo")
    public Result<?> insertPhoto(@Validated InsertPhotoVo insertPhotoVo) {

        return Result.ok();
    }

    @ApiOperation("后台更新照片信息")
    @PutMapping("/admin/photo")
    public Result<?> updatePhoto(@Validated UpdatePhotoVo updatePhotoVo) {

        return Result.ok();
    }

    @ApiOperation("后台查询相册下的照片")
    @GetMapping("/admin/photos/album")
    public Result<?> selectPhotosByAlbumId() {

        return Result.ok();
    }

    @ApiOperation("后台查询相册详情")
    @GetMapping("/admin/photo/{id}")
    public Result<?> selectPhoto(@PathVariable("id") Integer id) {

        return Result.ok();
    }

    @ApiOperation("后台移动照片到指定相册")
    @PatchMapping("/admin/photos/move")
    public Result<?> movePhotoToAlbum(@Validated MovePhotoVo movePhotoVo) {

        return Result.ok();
    }

    @ApiOperation("后台批量删除照片")
    @DeleteMapping("/admin/photos/")
    public Result<?> deletePhotos(@Validated DeletePhotosVo deletePhotosVo) {

        return Result.ok();
    }

    @ApiOperation("后台查询回收站的照片")
    @GetMapping("/admin/photos/recycle")
    public Result<?> selectPhotos() {

        return Result.ok();
    }

    @ApiOperation("后台批量恢复照片")
    @PatchMapping("/admin/photos/resume")
    public Result<?> resumePhotos(@Validated ResumePhotosVo resumePhotosVo) {

        return Result.ok();
    }










}
