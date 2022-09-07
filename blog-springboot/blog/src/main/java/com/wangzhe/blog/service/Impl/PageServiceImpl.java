package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.wangzhe.blog.entity.Page;
import com.wangzhe.blog.mapper.PageMapper;
import com.wangzhe.blog.service.PageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.InsertPageVo;
import com.wangzhe.blog.vo.UpdatePageVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-38-07
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {

    @Override
    public void insertPage(InsertPageVo insertPageVo) {
        Page page = new Page();
        BeanUtil.copyProperties(insertPageVo,page);
        this.save(page);
    }

    @Override
    public void updatePage(UpdatePageVo updatePageVo) {
        Page page = new Page();
        BeanUtil.copyProperties(updatePageVo,page);
        this.updateById(page);
    }
}
