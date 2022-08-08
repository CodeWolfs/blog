package com.wangzhe.blog.service;

import com.wangzhe.blog.entity.Resource;
import org.springframework.security.access.ConfigAttribute;

import java.util.List;
import java.util.Map;

public interface SecurityCommonService {
    List<Resource> loadDataSource();
}
