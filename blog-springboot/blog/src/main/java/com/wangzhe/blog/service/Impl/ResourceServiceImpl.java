package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangzhe.blog.dto.ResourceItemDto;
import com.wangzhe.blog.entity.Resource;
import com.wangzhe.blog.mapper.ResourceMapper;
import com.wangzhe.blog.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.InsertResourceVo;
import com.wangzhe.blog.vo.SelectResourceVo;
import com.wangzhe.blog.vo.UpdateResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<ResourceItemDto> selectResources(SelectResourceVo selectResourceVo) {
        List<ResourceItemDto> resourceItemDtos = resourceMapper.selectAllResources();
        //todo 后续添加条件过滤
        return resourceItemDtos;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertResource(InsertResourceVo insertResourceVo) {
        Resource resource = new Resource();
        BeanUtil.copyProperties(insertResourceVo,resource);
        this.save(resource);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateResource(UpdateResourceVo updateResourceVo) {
        Resource resource = new Resource();
        BeanUtil.copyProperties(updateResourceVo,resource);
        this.updateById(resource);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteResourceByPrimaryKey(Integer id) {
        LambdaQueryWrapper<Resource> resourceLambdaQueryWrapper = new LambdaQueryWrapper<>();
        resourceLambdaQueryWrapper.or().eq(Resource::getId,id).or().eq(Resource::getParentId,id);
        this.remove(resourceLambdaQueryWrapper);
    }
}
