package com.wangzhe.blog.controller;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.dto.MenuDto;
import com.wangzhe.blog.service.UtilsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@Api(tags = "工具合集")
@RequestMapping("/admin/utils")
public class UtilsController {
    @Autowired
    private UtilsService utilsService;

    @ApiOperation("一、判断日期是否为节假日")
    @GetMapping("/isWorkDayOrRestDay")
    @ApiImplicitParam(name = "date", value = "日期;格式为yyyyMMdd", dataTypeClass = String.class, paramType = "query",required = true)
    public Result<?> isWorkDayOrRestDay(@Validated @NotBlank(message = "日期不能为空")@RequestParam(value = "date") String date) {
        //todo 添加日期注解校验
        //http://www.gov.cn/zhengce/content/2021-10/25/content_5644835.htm
        String workDayOrRestDay = utilsService.isWorkDayOrRestDay(date);
        if(workDayOrRestDay.equals("0")) {
            return Result.ok("0",date+"为休息日");
        }else {
            return Result.ok("1",date+"为工作日");
        }
    }
}
