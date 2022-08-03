package com.wangzhe.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangZhe
 * @version 1.0
 * @className MybatisPlusConfig
 * @description
 * @date 2022/8/3 17:33
 */

@Configuration
@MapperScan("com.wangzhe.blog.mapper")
public class MybatisPlusConfig {
}
