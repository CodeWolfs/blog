package com.wangzhe.blog.service;

import com.wangzhe.blog.entity.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.InsertPageVo;
import com.wangzhe.blog.vo.UpdatePageVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2022-38-07
 */
public interface PageService extends IService<Page> {

    /**
     * 后台添加页面
     */
    void insertPage(InsertPageVo insertPageVo);

    /**
     * 后台更新页面
     */
    void updatePage(UpdatePageVo updatePageVo);
}
