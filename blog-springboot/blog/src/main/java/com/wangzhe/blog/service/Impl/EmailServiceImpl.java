package com.wangzhe.blog.service.Impl;

import com.wangzhe.blog.dto.EmailDto;
import com.wangzhe.blog.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author WangZhe
 * @version 1.0
 * @className EmailServiceImpl
 * @description 邮件服务实现类
 * @date 2022/8/5 9:17
 */

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleEmail(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailDto.getFrom());
        message.setTo(emailDto.getTo());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getContent());
        //发送邮件
        javaMailSender.send(message);
    }
}
