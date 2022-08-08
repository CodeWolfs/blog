package com.wangzhe.blog.security;

import cn.hutool.json.JSONUtil;
import com.wangzhe.blog.common.result.Result;
import com.wangzhe.blog.common.result.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WangZhe
 * @version 1.0
 * @className AccessDeniedHandlerImpl
 * @description 权限不足，访问拒绝处理
 * @date 2022/8/5 17:23
 */

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(Result.fail(ResultCode.AUTHORIZED)));
        response.getWriter().flush();
    }
}
