package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.SelectTalkDto;
import com.wangzhe.blog.entity.Talk;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.InsertTalkVo;
import com.wangzhe.blog.vo.SelectTalksVo;
import com.wangzhe.blog.vo.UpdateTalkVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2022-09-30
 */
public interface TalkService extends IService<Talk> {

    /**
     * 后台添加说说
     */
    void insertTalk(InsertTalkVo insertTalkVo);

    /**
     * 后台查询说说详情
     */
    SelectTalkDto selectTalk(Integer id);

    /**
     * 后台查询说说列表
     */
    Page<SelectTalkDto> selectTalks(SelectTalksVo selectTalksVo);

    /**
     * 后台更新说说
     */
    void updateTalk(UpdateTalkVo updateTalkVo);

    /**
     * 后台删除说说
     */
    void deleteTalk(Integer id);
}
