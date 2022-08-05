package com.wangzhe.blog.dto;

import com.wangzhe.blog.common.constant.CommonConst;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author WangZhe
 * @version 1.0
 * @className EmailDto
 * @description 邮件实体
 * @date 2022/8/5 9:11
 */
@Data
public class EmailDto {

    /**
     * 发件人
     */
    private String from = CommonConst.EMAIL_FROM;

    /**
     * 收件人
     */
    private String to;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

}
