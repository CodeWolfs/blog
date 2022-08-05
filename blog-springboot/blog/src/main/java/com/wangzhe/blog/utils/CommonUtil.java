package com.wangzhe.blog.utils;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author WangZhe
 * @version 1.0
 * @className CommonUtil
 * @description
 * @date 2022/8/5 8:48
 */

@Component
public class CommonUtil {
    /**
     * 生成随机数验证码
     * @param num 位数
     * @return 验证码字符串
     */
    public static String randomCode(int num) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();

    }
    /**
     * 检测邮箱是否合法
     *
     * @param email 邮箱
     * @return 合法状态
     */
    public static boolean checkEmail(String email) {
        String rule = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(rule);
        //正则表达式的匹配器
        Matcher m = p.matcher(email);
        //进行正则匹配
        return m.matches();
    }
}
