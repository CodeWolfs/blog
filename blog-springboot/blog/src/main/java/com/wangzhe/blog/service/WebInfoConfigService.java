package com.wangzhe.blog.service;

import com.wangzhe.blog.entity.WebInfoConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.UpdateWebInfoConfigVo;
import com.wangzhe.blog.vo.WebInfoConfigVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2022-55-07
 */
public interface WebInfoConfigService extends IService<WebInfoConfig> {

    /**
     * 后台保存网站信息
     */
    void insertWebInfoConfig(WebInfoConfigVo webInfoConfigVo);

    /**
     * 后台更新网站信息
     */
    void updateWebInfoConfig(UpdateWebInfoConfigVo updateWebInfoConfigVo);
}
