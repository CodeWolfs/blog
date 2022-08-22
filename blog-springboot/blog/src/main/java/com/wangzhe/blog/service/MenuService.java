package com.wangzhe.blog.service;

import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.dto.MenuItemDto;
import com.wangzhe.blog.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.InsertMenuVo;
import com.wangzhe.blog.vo.SelectMenusVo;
import com.wangzhe.blog.vo.UpdateMenuVo;

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
     */
    List<MenuDto> selectMenus();

    /**
     * 后台创建菜单
     */
    void insertMenu(InsertMenuVo insertMenuVo);

    /**
     * 后台更新菜单
     */
    void updateMenu(UpdateMenuVo updateMenuVo);

    /**
     * 后台删除菜单
     */
    void deleteMenuByPrimaryKey(Integer id);

    /**
     * 后台根据条件查询
     */
    List<Menu> selectMenusByCondition(SelectMenusVo selectMenusVo);
}
