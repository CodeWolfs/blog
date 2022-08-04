package com.wangzhe.blog.exception;

import com.wangzhe.blog.common.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static com.wangzhe.blog.common.result.ResultCode.*;

/**
 * @author WangZhe
 * @version 1.0
 * @className BlogException
 * @description blog业务异常类
 * @date 2022/8/4 9:37
 */

@Getter
@AllArgsConstructor
public class BizException extends RuntimeException{

    //错误码
    private Integer code = FAIL.getCode();

    //错误信息
    private String message;

    public BizException(String message) {
        this.message = message;
    }

    public BizException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getDesc();
    }

}
