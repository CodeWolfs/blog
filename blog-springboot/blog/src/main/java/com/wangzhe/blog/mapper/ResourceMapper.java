package com.wangzhe.blog.mapper;

import com.wangzhe.blog.dto.ResourceItemDto;
import com.wangzhe.blog.dto.RoleResourceDto;
import com.wangzhe.blog.entity.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 资源信息 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> selectResourceListByUserInfoId(@Param("userInfoId") Integer userInfoId);

    List<ResourceItemDto> selectAllResources();

    List<RoleResourceDto> selectRoleResource();
}
