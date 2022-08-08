package com.wangzhe.blog.security;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author WangZhe
 * @version 1.0
 * @className AccessDecisionManagerImpl
 * @description
 * @date 2022/8/8 9:04
 */

@Component
@Log4j2
public class AccessDecisionManagerImpl implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(BeanUtil.isEmpty(configAttributes)) {
            return;
        }
        for (ConfigAttribute configAttribute: configAttributes) {
            String needAuthority = configAttribute.getAttribute();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority :
                    authorities) {
                if (grantedAuthority.getAuthority().equals(needAuthority)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("抱歉，您没有访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
