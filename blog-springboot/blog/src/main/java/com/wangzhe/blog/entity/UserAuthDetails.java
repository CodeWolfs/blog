package com.wangzhe.blog.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author WangZhe
 * @version 1.0
 * @className UserAuthDetails
 * @description
 * @date 2022/8/4 16:26
 */

@Data
@Builder
public class UserAuthDetails implements UserDetails {

    /**
     * 用户认证id
     */
    private Integer id;

    /**
     * 用户信息id
     */
    private Integer userInfoId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录类型
     */
    private String loginType;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * ip原地址
     */
    private String ipSource;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 用户网名
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 个人简介
     */
    private String intro;

    /**
     * 个人网站
     */
    private String website;

    /**
     * 账号是否禁用
     */
    private String isDisable;


    /**
     * 用户资源
     */
    private List<Resource> resourceList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resourceList.stream().map(r -> new SimpleGrantedAuthority(r.getUri())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isDisable.equals("0");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
