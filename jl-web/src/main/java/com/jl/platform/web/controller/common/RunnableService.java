/**
 * guanyuhuhu 2016年6月9日
 */
package com.jl.platform.web.controller.common;

import com.jl.platform.common.Result;

/**
 * @author zhanglu
 */
public abstract class RunnableService<T> {
	public abstract Result<T> run();
}
