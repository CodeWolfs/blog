package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.ResultCode;
import com.wangzhe.blog.dto.MessageAdminDto;
import com.wangzhe.blog.entity.Message;
import com.wangzhe.blog.exception.BizException;
import com.wangzhe.blog.mapper.MessageMapper;
import com.wangzhe.blog.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhe.blog.vo.DeleteMessageVo;
import com.wangzhe.blog.vo.SelectMessagesVo;
import com.wangzhe.blog.vo.UpdateMessageReviewStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wz
 * @since 2022-42-19
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Page<MessageAdminDto> selectMessagesForAdmin(SelectMessagesVo selectMessagesVo) {
        Page<MessageAdminDto> messageAdminDtoPage = new Page<>(selectMessagesVo.getPageNum(), selectMessagesVo.getPageSize());
        messageAdminDtoPage = messageMapper.selectMessagesForAdmin(messageAdminDtoPage, selectMessagesVo);
        return messageAdminDtoPage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateMessageReviewStatus(UpdateMessageReviewStatusVo updateReviewStatusVo) {
        List<Message> collect = updateReviewStatusVo.getMessageIds().stream().map(id -> {
            Message message = new Message();
            message.setId(id);
            message.setReviewStatus(updateReviewStatusVo.getReviewStatus());
            return message;
        }).collect(Collectors.toList());
        this.updateBatchById(collect);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteMessageByBatchById(DeleteMessageVo deleteMessageVo) {
        if (deleteMessageVo.getDeleted().equals("0")) {
            //逻辑删除
            this.removeBatchByIds(deleteMessageVo.getMessageIds());

        } else if (deleteMessageVo.getDeleted().equals("1")) {
            //物理删除
            //todo 留言物理删除

        } else {
            throw new BizException(ResultCode.VALID_ERROR);
        }
    }
}
