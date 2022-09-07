package com.wangzhe.blog.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wz
 * @since 2022-55-07
 */
@Getter
@Setter
@TableName("web_info_config")
@ApiModel(value = "WebInfoConfig对象", description = "")
public class WebInfoConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("网站配置id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("网站头像")
    @TableField("web_avatar")
    private String webAvatar;

    @ApiModelProperty("网站名称")
    @TableField("web_name")
    private String webName;

    @ApiModelProperty("网站作者")
    @TableField("web_author")
    private String webAuthor;

    @ApiModelProperty("网站简介")
    @TableField("web_intro")
    private String webIntro;

    @ApiModelProperty("网站创建时间")
    @TableField("web_create_time")
    private LocalDateTime webCreateTime;

    @ApiModelProperty("网站公告")
    @TableField("web_notice")
    private String webNotice;

    @ApiModelProperty("备案号")
    @TableField("beian_num")
    private String beianNum;

    @ApiModelProperty("qq登录标志")
    @TableField("qq_flag")
    private String qqFlag;

    @ApiModelProperty("微博登录标志")
    @TableField("weibo_flag")
    private String weiboFlag;

    @ApiModelProperty("qq账号")
    @TableField("qq_count")
    private String qqCount;

    @ApiModelProperty("github账号")
    @TableField("github_count")
    private String githubCount;

    @ApiModelProperty("gitee账号")
    @TableField("gitee_count")
    private String giteeCount;

    @ApiModelProperty("用户头像")
    @TableField("user_avatar")
    private String userAvatar;

    @ApiModelProperty("游客头像")
    @TableField("visitor_avatar")
    private String visitorAvatar;

    @ApiModelProperty("默认文章封面")
    @TableField("default_article_cover")
    private String defaultArticleCover;

    @ApiModelProperty("邮箱通知")
    @TableField("email_notice")
    private String emailNotice;

    @ApiModelProperty("评论审核")
    @TableField("comment_verify")
    private String commentVerify;

    @ApiModelProperty("留言审核")
    @TableField("message_verify")
    private String messageVerify;

    @ApiModelProperty("打赏状态")
    @TableField("reward_status")
    private String rewardStatus;

    @ApiModelProperty("微信收款码")
    @TableField("wechat_pay")
    private String wechatPay;

    @ApiModelProperty("支付宝收款码")
    @TableField("ali_pay")
    private String aliPay;

    @ApiModelProperty("聊天室")
    @TableField("chat_room")
    private String chatRoom;

    @ApiModelProperty("websocket地址")
    @TableField("websocket_address")
    private String websocketAddress;

    @ApiModelProperty("音乐播放器")
    @TableField("music_player")
    private String musicPlayer;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

}
