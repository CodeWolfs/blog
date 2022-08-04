package com.wangzhe.blog.handler;

import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.common.result.ResultCode;
import com.wangzhe.blog.exception.BizException;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.wangzhe.blog.common.result.ResultCode.*;

import java.util.Objects;

/**
 * @author WangZhe
 * @version 1.0
 * @className GlobalExceptionHandler
 * @description 全局异常处理
 * @date 2022/8/4 9:44
 */

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    /***
     * @author WangZhe
     * @description 业务异常处理
     * @Date 9:50 2022/8/4
     **/
    @ExceptionHandler(value = BizException.class)
    public Result<?> blogExceptionHandler(BizException e) {
        return Result.fail(e.getCode(),e.getMessage());
    }

    /***
     * @author WangZhe
     * @description 处理参数绑定异常
     * @Date 9:55 2022/8/4
     **/
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> errorHandler(MethodArgumentNotValidException e) {
        return Result.fail(ResultCode.VALID_ERROR.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(value = BindException.class)
    public Result<?> errorHandler(BindException e) {
        return Result.fail(VALID_ERROR.getCode(),e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    /***
     * @author WangZhe
     * @description 系统异常（除了上面的异常之外的其他所有异常）
     * @Date 9:57 2022/8/4
     **/
    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e) {
        e.printStackTrace();
        return Result.fail(SYSTEM_ERROR.getCode(),SYSTEM_ERROR.getDesc());
    }


}
