package com.wangzhe.blog.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
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
    private static final String BASE_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        ArrayList<String> tableName = new ArrayList<>();
//        tableName.add("user_auth");
//        tableName.add("user_info");
//        tableName.add("role");
//        tableName.add("resource");
//        tableName.add("role_resource_relation");
//        tableName.add("article");
//        tableName.add("category");
//        tableName.add("tag");
//        tableName.add("article_tag_relation");
        tableName.add("comment");

        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("wz") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .commentDate("yyyy-mm-dd")
                            .outputDir(BASE_DIR + "\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.wangzhe.blog") // 设置父包名
//                            .moduleName("blog") //会显示在路径中
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.Impl")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, BASE_DIR + "\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName) // 设置需要生成的表名
                            .addTablePrefix("tb_", "c_") // 设置过滤表前缀
                            .serviceBuilder()
                            .fileOverride()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .fileOverride()
                            .enableLombok()
                            .logicDeleteColumnName("deleted")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .fileOverride()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            .fileOverride()
                            .enableBaseResultMap()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatMapperFileName("%sMapper");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
