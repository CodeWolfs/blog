package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.CommentForAdminDto;
import com.wangzhe.blog.service.CommentService;
import com.wangzhe.blog.vo.DeleteCommentVo;
import com.wangzhe.blog.vo.SelectCommentsVo;
import com.wangzhe.blog.vo.UpdateCommentReviewStatusVo;
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
 * @since 2022-59-17
 */
@RestController
@Api(tags = "评论管理")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("后台查询评论列表")
    @GetMapping("/admin/comments")
    public Result<Page<CommentForAdminDto>> selectComments(@Validated SelectCommentsVo selectCommentsVo) {
        Page<CommentForAdminDto> commentForAdminDtoPage = commentService.selectComments(selectCommentsVo);
        return Result.ok(commentForAdminDtoPage);
    }

    @ApiOperation("后台评论批量审核")
    @PatchMapping("/admin/comments")
    public Result<?> updateReviewStatus(UpdateCommentReviewStatusVo updateReviewStatusVo) {
        commentService.updateReviewStatus(updateReviewStatusVo);
        return Result.ok();
    }

    @ApiOperation("后台评论批量删除")
    @DeleteMapping("/admin/comments")
    public Result<?> deleteCommentByBatchById(DeleteCommentVo deleteCommentVo) {
        commentService.deleteCommentBatchById(deleteCommentVo);
        return Result.ok();
    }

}
