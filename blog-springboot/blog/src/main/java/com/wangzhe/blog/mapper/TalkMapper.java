package com.wangzhe.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectTalkDto;
import com.wangzhe.blog.entity.Talk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangzhe.blog.vo.SelectTalksVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-09-30
 */
@Mapper
public interface TalkMapper extends BaseMapper<Talk> {

    SelectTalkDto selectTalk(@Param("id") Integer id);

    Page<SelectTalkDto> selectTalks(@Param("page") Page<SelectTalkDto> selectTalkDtoPage, @Param("condition") SelectTalksVo selectTalksVo);
}
