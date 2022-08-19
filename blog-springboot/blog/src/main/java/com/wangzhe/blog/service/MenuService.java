package com.wangzhe.blog.service;

import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.SelectMenusVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2022-47-19
 */
public interface MenuService extends IService<Menu> {

    /**
     * 后台查询菜单列表
     * @param selectMenusVo
     * @return
     */
    List<MenuDto> selectMenus(SelectMenusVo selectMenusVo);
}
