package com.wangzhe.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.CommentForAdminDto;
import com.wangzhe.blog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangzhe.blog.vo.SelectCommentsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-49-17
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 分页查询 后台评论
     */
    Page<CommentForAdminDto> selectCommentsForAdmin(@Param("page") Page<CommentForAdminDto> commentPage, @Param("condition") SelectCommentsVo selectCommentsVo);
}
