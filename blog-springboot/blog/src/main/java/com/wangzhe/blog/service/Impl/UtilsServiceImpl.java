package com.wangzhe.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangzhe.blog.entity.ChinaHoliday;
import com.wangzhe.blog.service.ChinaHolidayService;
import com.wangzhe.blog.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class UtilsServiceImpl implements UtilsService {

    @Autowired
    private ChinaHolidayService chinaHolidayService;

    @Override
    public String isWorkDayOrRestDay(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String[] workDay = {"星期一","星期二","星期三","星期四","星期五"};;
        String[] restDay = {"星期六","星期日"};
        String result = null;

        try {
            Date parseDate = dateFormat.parse(date);
            String weekOfDate = getWeekOfDate(parseDate);
            boolean workFlag = Arrays.asList(workDay).contains(weekOfDate);
            LambdaQueryWrapper<ChinaHoliday> chinaHolidayLambdaQueryWrapper = new LambdaQueryWrapper<>();
            if(workFlag) {
                result="1";
                //判断是否节假日
                chinaHolidayLambdaQueryWrapper.eq(ChinaHoliday::getDate,date);
                chinaHolidayLambdaQueryWrapper.eq(ChinaHoliday::getType,'0');
                long count = chinaHolidayService.count(chinaHolidayLambdaQueryWrapper);
                if(count > 0) {
                    result = "0";
                }
            } else {
                result = "0";
                //判断是否调休
                chinaHolidayLambdaQueryWrapper.eq(ChinaHoliday::getDate,date);
                chinaHolidayLambdaQueryWrapper.eq(ChinaHoliday::getType,'1');
                long count = chinaHolidayService.count(chinaHolidayLambdaQueryWrapper);
                if(count > 0) {
                    result = "1";
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获取日期的 星期
     * @param date
     * @return
     */
    private String getWeekOfDate(Date date) {
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        String week = dateFm.format(date);
        return week;
    }
}
