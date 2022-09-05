package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.PhotoAlbumViewDataDto;
import com.wangzhe.blog.entity.Photo;
import com.wangzhe.blog.service.PhotoService;
import com.wangzhe.blog.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 前端控制器
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
    public Result<?> insertPhotos(@Validated InsertPhotoVo insertPhotoVo) {
        photoService.insertPhotos(insertPhotoVo);
        return Result.ok();
    }

    @ApiOperation("后台更新照片信息")
    @PutMapping("/admin/photo")
    public Result<?> updatePhoto(@Validated UpdatePhotoVo updatePhotoVo) {
        photoService.updatePhoto(updatePhotoVo);
        return Result.ok();
    }

    @ApiOperation("后台查询相册下的照片")
    @GetMapping("/admin/photos/album")
    public Result<Page<Photo>> selectPhotosByAlbumId(@Validated SelectPhotosVo selectPhotosVo) {
        Page<Photo> photoPage = photoService.selectPhotosByAlbumId(selectPhotosVo);
        return Result.ok(photoPage);
    }

    @ApiOperation("后台查询相片详情")
    @GetMapping("/admin/photo/{id}")
    public Result<Photo> selectPhoto(@PathVariable("id") @Valid @NotNull(message = "相片id不能为空") Integer id) {
        Photo byId = photoService.getById(id);
        return Result.ok(byId);
    }

    @ApiOperation("后台移动照片到指定相册")
    @PatchMapping("/admin/photos/move")
    public Result<?> movePhotoToAlbum(@Validated MovePhotoVo movePhotoVo) {
        photoService.movePhotoToAlbum(movePhotoVo);
        return Result.ok();
    }

    @ApiOperation("后台查询所有相册视图数据")
    @GetMapping("/admin/photo/albumView")
    @ApiImplicitParam(name = "albumId", value = "当前相册id", dataTypeClass = Integer.class, required = true, paramType = "query")
    public Result<List<PhotoAlbumViewDataDto>> selectPhotoAlbumViewData(@Valid @NotNull(message = "相册id不能为空") @RequestParam("albumId") Integer albumId) {
        List<PhotoAlbumViewDataDto> photoAlbumViewDataDtoList = photoService.selectPhotoAlbumViewData(albumId);
        return Result.ok(photoAlbumViewDataDtoList);
    }

    @ApiOperation("后台批量删除照片")
    @DeleteMapping("/admin/photos/")
    public Result<?> deletePhotos(@Validated DeletePhotosVo deletePhotosVo) {
        photoService.deletePhotos(deletePhotosVo);
        return Result.ok();
    }

    @ApiOperation("后台查询回收站的照片")
    @GetMapping("/admin/photos/recycle")
    public Result<List<Photo>> selectPhotos() {
        List<Photo> photos = photoService.selectPhotosForRecycle();
        return Result.ok(photos);
    }

    @ApiOperation("后台批量恢复照片")
    @PatchMapping("/admin/photos/resume")
    public Result<?> resumePhotos(@Validated ResumePhotosVo resumePhotosVo) {
        photoService.resumePhotos(resumePhotosVo);
        return Result.ok();
    }


}
