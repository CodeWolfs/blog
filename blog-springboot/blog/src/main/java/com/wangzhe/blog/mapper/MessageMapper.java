package com.wangzhe.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.MessageAdminDto;
import com.wangzhe.blog.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangzhe.blog.vo.SelectMessagesVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-08-19
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    Page<MessageAdminDto> selectMessagesForAdmin(@Param("page")Page<MessageAdminDto> page, @Param("condition") SelectMessagesVo selectMessagesVo);
}
