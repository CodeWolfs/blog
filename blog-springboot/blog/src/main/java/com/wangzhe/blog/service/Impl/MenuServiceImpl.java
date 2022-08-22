package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.dto.MenuItemDto;
import com.wangzhe.blog.entity.Menu;
import com.wangzhe.blog.mapper.MenuMapper;
import com.wangzhe.blog.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.InsertMenuVo;
import com.wangzhe.blog.vo.SelectMenusVo;
import com.wangzhe.blog.vo.UpdateMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-47-19
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuDto> selectMenus() {
        return menuMapper.selectMenus();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertMenu(InsertMenuVo insertMenuVo) {
        Menu menu = new Menu();
        BeanUtil.copyProperties(insertMenuVo, menu);
        this.save(menu);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateMenu(UpdateMenuVo updateMenuVo) {
        Menu menu = new Menu();
        BeanUtil.copyProperties(updateMenuVo,menu);
        this.updateById(menu);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteMenuByPrimaryKey(Integer id) {
        //删除目录和子菜单项
        LambdaQueryWrapper<Menu> menuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        menuLambdaQueryWrapper.eq(Menu::getParentId,id);
        this.remove(menuLambdaQueryWrapper);
        this.removeById(id);
    }

    @Override
    public List<Menu> selectMenusByCondition(SelectMenusVo selectMenusVo) {
        LambdaQueryWrapper<Menu> menuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        menuLambdaQueryWrapper.like(Menu::getName,selectMenusVo.getName());
        return this.list(menuLambdaQueryWrapper);
    }
}
