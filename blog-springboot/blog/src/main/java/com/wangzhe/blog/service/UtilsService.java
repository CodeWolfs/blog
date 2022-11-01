package com.wangzhe.blog.service;

public interface UtilsService {
    /**
     * 判断日期 是休息还是工作日
     * @param date 日期
     * @return 0：休息，1：工作
     */
    String isWorkDayOrRestDay(String date);
}
