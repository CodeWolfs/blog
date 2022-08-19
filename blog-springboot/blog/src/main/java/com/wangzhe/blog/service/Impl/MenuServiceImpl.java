package com.wangzhe.blog.service.Impl;

import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.entity.Menu;
import com.wangzhe.blog.mapper.MenuMapper;
import com.wangzhe.blog.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.SelectMenusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
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
    public List<MenuDto> selectMenus(SelectMenusVo selectMenusVo) {
        List<MenuDto> menuDtoList = menuMapper.selectMenus(selectMenusVo);
        return menuDtoList;
    }
}
