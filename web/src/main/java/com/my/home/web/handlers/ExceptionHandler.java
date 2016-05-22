package com.my.home.web.handlers;

import com.alibaba.fastjson.JSON;
import com.my.home.common.Result;
import com.my.home.common.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lishoubo on 16/5/21.
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        responseResult(request, response);
        return modelAndView;
    }

    private void responseResult(HttpServletRequest request, HttpServletResponse response) {
        try {
            Result result = Result.result(StatusCode.SYSTEM_ERROR);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(result));
        } catch (Throwable e) {
            logger.error(request.getPathInfo(), e);
        }
    }

}
