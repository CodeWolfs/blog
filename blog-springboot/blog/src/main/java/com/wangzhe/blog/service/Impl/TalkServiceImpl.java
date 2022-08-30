package com.wangzhe.blog.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectTalkDto;
import com.wangzhe.blog.entity.AppImageRelation;
import com.wangzhe.blog.entity.Talk;
import com.wangzhe.blog.mapper.TalkMapper;
import com.wangzhe.blog.service.AppImageRelationService;
import com.wangzhe.blog.service.TalkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.InsertTalkVo;
import com.wangzhe.blog.vo.SelectTalksVo;
import com.wangzhe.blog.vo.UpdateTalkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-09-30
 */
@Service
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk> implements TalkService {

    @Autowired
    private TalkMapper talkMapper;

    @Autowired
    private AppImageRelationService appImageRelationService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertTalk(InsertTalkVo insertTalkVo) {
        Talk talk = new Talk();
        BeanUtil.copyProperties(insertTalkVo,talk);
        this.save(talk);
        //处理图片
        if(CollUtil.isNotEmpty(insertTalkVo.getImageUrlList())) {
            List<AppImageRelation> collect = insertTalkVo.getImageUrlList().stream().map(imageUrl -> {
                AppImageRelation appImageRelation = new AppImageRelation();
                appImageRelation.setRelationId(talk.getId());
                appImageRelation.setImageUrl(imageUrl);
                appImageRelation.setApplyType("10");
                return appImageRelation;
            }).collect(Collectors.toList());
            appImageRelationService.saveBatch(collect);
        }
    }

    @Override
    public SelectTalkDto selectTalk(Integer id) {
        return talkMapper.selectTalk(id);
    }

    @Override
    public Page<SelectTalkDto> selectTalks(SelectTalksVo selectTalksVo) {
        Page<SelectTalkDto> selectTalkDtoPage = new Page<>(selectTalksVo.getPageNum(),selectTalksVo.getPageSize());
        selectTalkDtoPage = talkMapper.selectTalks(selectTalkDtoPage,selectTalksVo);
        return selectTalkDtoPage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateTalk(UpdateTalkVo updateTalkVo) {
        Talk talk = new Talk();
        BeanUtil.copyProperties(updateTalkVo,talk);
        this.updateById(talk);

        //处理图片
        LambdaQueryWrapper<AppImageRelation> appImageRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        appImageRelationLambdaQueryWrapper.eq(AppImageRelation::getRelationId,updateTalkVo.getId());
        appImageRelationLambdaQueryWrapper.eq(AppImageRelation::getApplyType,"10");
        appImageRelationService.remove(appImageRelationLambdaQueryWrapper);

        //todo 更新图片，图片处理，需要删除文件
        if(CollUtil.isNotEmpty(updateTalkVo.getImageUrlList())) {
            List<AppImageRelation> collect = updateTalkVo.getImageUrlList().stream().map(imageUrl -> {
                AppImageRelation appImageRelation = new AppImageRelation();
                appImageRelation.setRelationId(updateTalkVo.getId());
                appImageRelation.setImageUrl(imageUrl);
                appImageRelation.setApplyType("10");
                return appImageRelation;
            }).collect(Collectors.toList());
            appImageRelationService.saveBatch(collect);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteTalk(Integer id) {
        this.removeById(id);
        //处理图片
        LambdaQueryWrapper<AppImageRelation> appImageRelationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        appImageRelationLambdaQueryWrapper.eq(AppImageRelation::getRelationId, id);
        appImageRelationLambdaQueryWrapper.eq(AppImageRelation::getApplyType, "10");
        appImageRelationService.remove(appImageRelationLambdaQueryWrapper);
        //todo 存储桶内删除文件

    }
}
