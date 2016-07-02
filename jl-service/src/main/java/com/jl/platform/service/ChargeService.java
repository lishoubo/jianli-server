/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.service;

import com.jl.platform.common.Result;
import com.jl.platform.service.model.Charge;

/**
 * @author zhanglu
 */
public interface ChargeService {

	/**
	 * @return Result
	 */
	public Result save(Charge charge);

}
