package com.wangzhe.blog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectUsersDto;
import com.wangzhe.blog.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangzhe.blog.vo.SelectUsersVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户详细信息 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    Page<SelectUsersDto> selectUsers(@Param("page") Page<SelectUsersDto> selectUsersDtoPage, @Param("condition") SelectUsersVo selectUsersVo);
}
