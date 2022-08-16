package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.common.result.ResultCode;
import com.wangzhe.blog.entity.Article;
import com.wangzhe.blog.entity.ArticleTagRelation;
import com.wangzhe.blog.entity.Category;
import com.wangzhe.blog.entity.Tag;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.ArticleTagRelationMapper;
import com.wangzhe.blog.mapper.TagMapper;
import com.wangzhe.blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.SelectTagVo;
import com.wangzhe.blog.vo.UpdateTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-40-08
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagRelationMapper articleTagRelationMapper;

    @Override
    public Page<Tag> selectTag(SelectTagVo selectTagVo) {
        Page<Tag> tagPage = new Page<>(selectTagVo.getPageNum(), selectTagVo.getPageSize());
        LambdaQueryWrapper<Tag> tagLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (BeanUtil.isNotEmpty(selectTagVo.getTagName())) {
            tagLambdaQueryWrapper.like(Tag::getTagName,selectTagVo.getTagName());
        }
        tagLambdaQueryWrapper.orderByDesc(Tag::getCreateTime);
        tagPage = tagMapper.selectPage(tagPage, tagLambdaQueryWrapper);
        return tagPage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateTagByPrimaryKey(UpdateTagVo updateTagVo) {
        //判断标签名是否存在
        LambdaQueryWrapper<Tag> tagLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tagLambdaQueryWrapper.ne(Tag::getId,updateTagVo.getId());
        tagLambdaQueryWrapper.eq(Tag::getTagName,updateTagVo.getTagName());
        long count = this.count(tagLambdaQueryWrapper);
        if(count > 0) {
            throw new BizException(ResultCode.TAG_EXIST);
        }
        Tag tag = new Tag();
        BeanUtil.copyProperties(updateTagVo,tag);
        this.updateById(tag);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result<?> deleteTagByIds(List<Integer> tagIds) {
        LambdaQueryWrapper<ArticleTagRelation> articleTagRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        articleTagRelationLambdaQueryWrapper.in(ArticleTagRelation::getTagId,tagIds);
        List<ArticleTagRelation> articleTagRelations = articleTagRelationMapper.selectList(articleTagRelationLambdaQueryWrapper);
        if (BeanUtil.isNotEmpty(articleTagRelations)){
            Set<Integer> collect = articleTagRelations.stream().map(ArticleTagRelation::getTagId).collect(Collectors.toSet());
            List<Tag> tagList = tagMapper.selectBatchIds(collect);
            return Result.fail(ResultCode.TAG_USING,tagList);
        }
        this.removeBatchByIds(tagIds);
        return Result.ok();
    }

    @Override
    public void insertTag(String tagName) {
        LambdaQueryWrapper<Tag> tagLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tagLambdaQueryWrapper.eq(Tag::getTagName,tagName);
        Long aLong = tagMapper.selectCount(tagLambdaQueryWrapper);
        if (aLong > 0) {
            throw new BizException(ResultCode.TAG_EXIST);
        }
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tagMapper.insert(tag);
    }
}
