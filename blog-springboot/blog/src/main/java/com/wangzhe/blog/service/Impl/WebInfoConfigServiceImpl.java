package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.wangzhe.blog.entity.WebInfoConfig;
import com.wangzhe.blog.mapper.WebInfoConfigMapper;
import com.wangzhe.blog.service.WebInfoConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.UpdateWebInfoConfigVo;
import com.wangzhe.blog.vo.WebInfoConfigVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-55-07
 */
@Service
public class WebInfoConfigServiceImpl extends ServiceImpl<WebInfoConfigMapper, WebInfoConfig> implements WebInfoConfigService {

    @Override
    public void insertWebInfoConfig(WebInfoConfigVo webInfoConfigVo) {
        WebInfoConfig webInfoConfig = new WebInfoConfig();
        BeanUtil.copyProperties(webInfoConfigVo,webInfoConfig);
        this.save(webInfoConfig);
    }

    @Override
    public void updateWebInfoConfig(UpdateWebInfoConfigVo updateWebInfoConfigVo) {
        WebInfoConfig webInfoConfig = new WebInfoConfig();
        BeanUtil.copyProperties(updateWebInfoConfigVo,webInfoConfig);
        this.updateById(webInfoConfig);
    }
}
