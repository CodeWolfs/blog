package com.wangzhe.blog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangZhe
 * @version 1.0
 * @className IgnoreUrlsConfig
 * @description 过滤名单
 * @date 2022/8/5 17:40
 */

@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
@Component
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();
}
