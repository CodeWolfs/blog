package com.wangzhe.blog.service;

import com.wangzhe.blog.dto.EmailDto;

/**
 * 邮件服务
 */
public interface EmailService {
    /**
     * 发送邮件
     * @param emailDto 邮件实体
     */
    void sendSimpleEmail(EmailDto emailDto);
}
