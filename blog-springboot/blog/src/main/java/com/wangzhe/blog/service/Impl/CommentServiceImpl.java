package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.CommentForAdminDto;
import com.wangzhe.blog.entity.Comment;
import com.wangzhe.blog.mapper.CommentMapper;
import com.wangzhe.blog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.SelectCommentsVo;
import com.wangzhe.blog.vo.UpdateReviewStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-49-17
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Page<CommentForAdminDto> selectComments(SelectCommentsVo selectCommentsVo) {
        Page<CommentForAdminDto> commentPage = new Page<>(selectCommentsVo.getPageNum(), selectCommentsVo.getPageSize());
        commentPage = commentMapper.selectCommentsForAdmin(commentPage, selectCommentsVo);
        return commentPage;

    }

    @Override
    public void updateReviewStatus(UpdateReviewStatusVo updateReviewStatusVo) {
        List<Comment> collect = updateReviewStatusVo.getCommentIds().stream().map(id -> {
            Comment comment = new Comment();
            comment.setId(id);
            comment.setReviewStatus(updateReviewStatusVo.getReviewStatus());
            return comment;
        }).collect(Collectors.toList());
        this.updateBatchById(collect);
    }
}
