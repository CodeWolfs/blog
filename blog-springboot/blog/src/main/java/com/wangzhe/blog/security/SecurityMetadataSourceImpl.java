package com.wangzhe.blog.security;

import com.wangzhe.blog.entity.Resource;
import com.wangzhe.blog.service.Impl.SecurityCommonServiceImpl;
import com.wangzhe.blog.service.SecurityCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author WangZhe
 * @version 1.0
 * @className SecurityMetadataSourceImpl
 * @description
 * @date 2022/8/8 9:06
 */

@Component
public class SecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {
    private static List<Resource> resourceList = null;

    @Autowired
    private SecurityCommonService securityCommonService;

    @PostConstruct
    public void loadDataSource() {
        resourceList = securityCommonService.loadDataSource();
    }

    public void clearDataSource() {
        resourceList = null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(resourceList == null) {
            this.loadDataSource();
        }
        FilterInvocation fi = (FilterInvocation) object;
        String uri = fi.getRequest().getRequestURI();
        String method = fi.getRequest().getMethod();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        ArrayList<ConfigAttribute> configAttributes = new ArrayList<>();
        for (Resource resource :
                resourceList) {
            if(antPathMatcher.match(uri,resource.getUri()) && resource.getRequestMethod().equals(method.toLowerCase())) {
                configAttributes.add(new SecurityConfig(resource.getUri()));
            }
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
