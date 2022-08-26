package com.wangzhe.blog.mapper;

import com.wangzhe.blog.dto.RoleDto;
import com.wangzhe.blog.dto.RoleMenuDto;
import com.wangzhe.blog.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    RoleDto selectRoleById(@Param("roleId") Integer roleId);

}
