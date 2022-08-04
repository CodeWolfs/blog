package com.wangzhe.blog.mapper;

import com.wangzhe.blog.entity.UserAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户认证信息 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Mapper
public interface UserAuthMapper extends BaseMapper<UserAuth> {

}
