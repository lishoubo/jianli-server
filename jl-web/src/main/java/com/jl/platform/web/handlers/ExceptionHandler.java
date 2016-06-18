package com.jl.platform.web.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;

/**
 * Created by lishoubo on 16/5/21.
 */
public class ExceptionHandler implements HandlerExceptionResolver {
	private static Logger logger = LoggerFactory
			.getLogger(ExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		responseResult(request, response);
		return modelAndView;
	}

	private void responseResult(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Result result = new Result(StatusCode.SYSTEM_ERROR);
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(JSON.toJSONString(result));
		} catch (Throwable e) {
			logger.error(request.getPathInfo(), e);
		}
	}

}
