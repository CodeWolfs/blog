package com.wangzhe.blog.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author WangZhe
 * @version 1.0
 * @className MybatisPlusGenerator
 * @description
 * @date 2022/8/3 17:44
 */

public class MybatisPlusGenerator {
    private static final String URL = "jdbc:mysql://localhost:3306/blog";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("WZ") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D://test"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.wangzhe.blog") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_simple") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
