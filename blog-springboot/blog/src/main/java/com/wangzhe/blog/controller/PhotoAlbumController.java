package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.service.PhotoAlbumService;
import com.wangzhe.blog.vo.InsertPhotoAlbumVo;
import com.wangzhe.blog.vo.SelectPhotoAlbums;
import com.wangzhe.blog.vo.UpdatePhotoAlbumVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-27-30
 */
@RestController
@Api(tags = "相册管理")
public class PhotoAlbumController {

    @Autowired
    PhotoAlbumService photoAlbumService;

    @ApiOperation("后台添加相册")
    @PostMapping("/admin/photoAlbum")
    public Result<?> insertPhotoAlbum(@Validated InsertPhotoAlbumVo insertPhotoAlbumVo) {
        photoAlbumService.insertPhotoAlbum(insertPhotoAlbumVo);
        return Result.ok();
    }

    @ApiOperation("后台更新相册")
    @PutMapping("/admin/photoAlbum")
    public Result<?> updatePhotoAlbum(@Validated UpdatePhotoAlbumVo updatePhotoAlbumVo) {
        photoAlbumService.updatePhotoAlbum(updatePhotoAlbumVo);
        return Result.ok();
    }

    @ApiOperation("后台删除相册")
    @DeleteMapping("/admin/photoAlbum/{id}")
    public Result<?> deletePhotoAlbum(@PathVariable("id") Integer id) {
        photoAlbumService.deletePhotoAlbum(id);
        return Result.ok();
    }

    @ApiOperation("后台查询相册列表")
    @GetMapping("/admin/photoAlbums")
    public Result<?> selectPhotoAlbums(@Validated SelectPhotoAlbums selectPhotoAlbums) {

        return Result.ok();
    }

    @ApiOperation("后台查询相册详情")
    @GetMapping("/admin/photoAlbum/{id}")
    public Result<?> selectPhotoAlbum(@Valid @PathVariable("id") Integer id) {


        return Result.ok();
    }






}
