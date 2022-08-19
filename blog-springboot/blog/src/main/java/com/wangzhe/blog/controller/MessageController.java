package com.wangzhe.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.MessageAdminDto;
import com.wangzhe.blog.service.MessageService;
import com.wangzhe.blog.vo.DeleteMessageVo;
import com.wangzhe.blog.vo.SelectMessagesVo;
import com.wangzhe.blog.vo.UpdateMessageReviewStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wz
 * @since 2022-42-19
 */
@RestController
@Api(tags = "留言管理")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @ApiOperation("后台查询留言列表")
    @GetMapping("/admin/messages")
    public Result<?> selectMessagesForAdmin(SelectMessagesVo selectMessagesVo) {
        Page<MessageAdminDto> page = messageService.selectMessagesForAdmin(selectMessagesVo);
        return Result.ok(page);
    }

    @ApiOperation("后台留言批量审核")
    @PatchMapping("/admin/messages")
    public Result<?> updateMessageReviewStatus(UpdateMessageReviewStatusVo updateReviewStatusVo) {
        messageService.updateMessageReviewStatus(updateReviewStatusVo);
        return Result.ok();
    }

    @ApiOperation("后台留言批量删除")
    @DeleteMapping("/admin/messages")
    public Result<?> deleteMessageByBatchById(DeleteMessageVo deleteMessageVo) {
        messageService.deleteMessageByBatchById(deleteMessageVo);
        return Result.ok();
    }









}
