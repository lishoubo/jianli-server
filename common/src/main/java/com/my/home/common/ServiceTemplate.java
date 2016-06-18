/**
 * guanyuhuhu 2016年6月9日
 */
package com.my.home.common;

/**
 * @author zhanglu
 */
public class ServiceTemplate<T> {
	public Result<T> executeWithoutTransaction(RunnableService<T> service) {
		try {
			service.run();
		} catch (BizException e1) {

		} catch (Throwable e2) {

		}
		return Result.result(StatusCode.SUCCESS);
	}

}
