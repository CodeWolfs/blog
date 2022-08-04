package com.wangzhe.blog.mapper;

import com.wangzhe.blog.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
