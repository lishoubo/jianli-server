/**
 * guanyuhuhu 2016年6月9日
 */
package com.my.home.web.controller.common;

import com.my.home.common.Result;

/**
 * @author zhanglu
 */
public abstract class RunnableService<T> {
	public abstract Result<T> run();
}
