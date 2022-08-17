package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.CommentForAdminDto;
import com.wangzhe.blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.SelectCommentsVo;
import com.wangzhe.blog.vo.UpdateReviewStatusVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2022-49-17
 */
public interface CommentService extends IService<Comment> {

    /**
     * 分页查询后台评论
     */
    Page<CommentForAdminDto> selectComments(SelectCommentsVo selectCommentsVo);

    void updateReviewStatus(UpdateReviewStatusVo updateReviewStatusVo);
}
