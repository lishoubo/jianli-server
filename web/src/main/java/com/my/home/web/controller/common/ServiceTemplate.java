/**
 * guanyuhuhu 2016年6月9日
 */
package com.my.home.web.controller.common;

import org.springframework.stereotype.Component;

import com.my.home.common.BizException;
import com.my.home.common.Result;
import com.my.home.common.StatusCode;

/**
 * @author zhanglu
 */
@Component("serviceTemplate")
public class ServiceTemplate<T> {
	public Result<T> executeWithoutTransaction(RunnableService<T> service) {
		try {
			return service.run();
		} catch (BizException e1) {
			return new Result<T>(e1);
		} catch (Throwable e2) {
			return new Result<T>(StatusCode.SYSTEM_ERROR);
		}
	}
}
