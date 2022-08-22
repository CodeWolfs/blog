package com.wangzhe.blog.service.Impl;

import com.wangzhe.blog.entity.Resource;
import com.wangzhe.blog.mapper.ResourceMapper;
import com.wangzhe.blog.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 资源信息 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> selectResources() {
        return null;
    }
}
