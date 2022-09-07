package com.wangzhe.blog.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangZhe
 * @version 1.0
 * @className WebInfoConfigVo
 * @description
 * @date 2022/9/7 9:50
 */

@Data
@ApiModel("保存网站配置信息入参实体")
public class WebInfoConfigVo {

    @ApiModelProperty("网站头像")
    private String webAvatar;

    @ApiModelProperty("网站名称")
    private String webName;

    @ApiModelProperty("网站作者")
    private String webAuthor;

    @ApiModelProperty("网站简介")
    private String webIntro;

    @ApiModelProperty("网站创建时间")
    private LocalDateTime webCreateTime;

    @ApiModelProperty("网站公告")
    private String webNotice;

    @ApiModelProperty("备案号")
    private String beianNum;

    @ApiModelProperty("qq登录标志")
    private String qqFlag;

    @ApiModelProperty("微博登录标志")
    private String weiboFlag;

    @ApiModelProperty("qq账号")
    private String qqCount;

    @ApiModelProperty("github账号")
    private String githubCount;

    @ApiModelProperty("gitee账号")
    private String giteeCount;

    @ApiModelProperty("用户头像")
    private String userAvatar;

    @ApiModelProperty("游客头像")
    private String visitorAvatar;

    @ApiModelProperty("默认文章封面")
    private String defaultArticleCover;

    @ApiModelProperty("邮箱通知")
    private String emailNotice;

    @ApiModelProperty("评论审核")
    private String commentVerify;

    @ApiModelProperty("留言审核")
    private String messageVerify;

    @ApiModelProperty("打赏状态")
    private String rewardStatus;

    @ApiModelProperty("微信收款码")
    private String wechatPay;

    @ApiModelProperty("支付宝收款码")
    private String aliPay;

    @ApiModelProperty("聊天室")
    private String chatRoom;

    @ApiModelProperty("websocket地址")
    private String websocketAddress;

    @ApiModelProperty("音乐播放器")
    private String musicPlayer;

}
