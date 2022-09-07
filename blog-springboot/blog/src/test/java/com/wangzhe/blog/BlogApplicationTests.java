package com.wangzhe.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String rule = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(rule);
        //正则表达式的匹配器
        Matcher m = p.matcher("2546972682@qq.c");
        //进行正则匹配
        System.out.println(m.matches());
    }

    @Test
    void test() {
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.matches("admin", "$2a$10$.wiWagIFzQIgLQyEhr8y1.RnwQpgrqNRBiJ0ejDREde1OQIpxbgEK"));
    }

}
