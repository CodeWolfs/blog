package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangzhe.blog.entity.Resource;
import com.wangzhe.blog.mapper.ResourceMapper;
import com.wangzhe.blog.service.SecurityCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author WangZhe
 * @version 1.0
 * @className SecurityCommonServiceImpl
 * @description
 * @date 2022/8/8 9:14
 */

@Service
public class SecurityCommonServiceImpl implements SecurityCommonService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> loadDataSource() {
        LambdaQueryWrapper<Resource> resourceLambdaQueryWrapper = new LambdaQueryWrapper<>();
        resourceLambdaQueryWrapper.eq(Resource::getIsAnonymous,"0");
        resourceLambdaQueryWrapper.isNotNull(Resource::getParentId);
        //todo 添加非空判断
        return resourceMapper.selectList(resourceLambdaQueryWrapper);
    }
}

