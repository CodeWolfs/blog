package com.wangzhe.blog.service;

import com.wangzhe.blog.dto.ResourceItemDto;
import com.wangzhe.blog.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.InsertResourceVo;
import com.wangzhe.blog.vo.SelectResourceVo;
import com.wangzhe.blog.vo.UpdateResourceVo;

import java.util.List;

/**
 * <p>
 * 资源信息 服务类
 * </p>
 *
 * @author wz
 * @since 2022-22-04
 */
public interface ResourceService extends IService<Resource> {

    /**
     * 后台查询资源列表
     */
    List<ResourceItemDto> selectResources(SelectResourceVo selectResourceVo);

    /**
     * 后台添加资源
     */
    void insertResource(InsertResourceVo insertResourceVo);

    /**
     * 后台更新资源
     */
    void updateResource(UpdateResourceVo updateResourceVo);

    /**
     * 后台删除资源
     */
    void deleteResourceByPrimaryKey(Integer id);
}
