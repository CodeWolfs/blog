package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.SelectTagVo;
import com.wangzhe.blog.vo.UpdateTagVo;

import java.util.List;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
public interface TagService extends IService<Tag> {

    /**
     * 查询标签列表
     **/
    Page<Tag> selectTag(SelectTagVo selectTagVo);

    /**
     * 通过标签id更新标签
     */
    void updateTagByPrimaryKey(UpdateTagVo updateTagVo);

    /**
     * 批量删除标签通过id
     */
    Result<?> deleteTagByIds(List<Integer> tagIds);

    /**
     * 新增标签
     */
    void insertTag(String tagName);
}
