package com.wangzhe.blog.mapper;

import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangzhe.blog.vo.SelectMenusVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2022-47-19
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuDto> selectMenus(@Param("condition") SelectMenusVo selectMenusVo);
}
