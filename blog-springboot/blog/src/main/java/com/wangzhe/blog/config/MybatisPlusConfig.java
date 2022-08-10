package com.wangzhe.blog.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangZhe
 * @version 1.0
 * @className MybatisPlusConfig
 * @description MybatisPlus配置类
 * @date 2022/8/3 17:33
 */

@Configuration
@MapperScan("com.wangzhe.blog.mapper")
public class MybatisPlusConfig {
    /**
     *
     * @return 分页插件拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
