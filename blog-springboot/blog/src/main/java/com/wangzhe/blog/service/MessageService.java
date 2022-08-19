package com.wangzhe.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.dto.MessageAdminDto;
import com.wangzhe.blog.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangzhe.blog.vo.DeleteMessageVo;
import com.wangzhe.blog.vo.SelectMessagesVo;
import com.wangzhe.blog.vo.UpdateMessageReviewStatusVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wz
 * @since 2022-42-19
 */
public interface MessageService extends IService<Message> {

    /**
     * 后台查询留言列表
     */
    Page<MessageAdminDto> selectMessagesForAdmin(SelectMessagesVo selectMessagesVo);

    /**
     * 后天更新留言审核状态列表
     */
    void updateMessageReviewStatus(UpdateMessageReviewStatusVo updateReviewStatusVo);

    /**
     * 后台删除留言列表
     */
    void deleteMessageByBatchById(DeleteMessageVo deleteMessageVo);
}
