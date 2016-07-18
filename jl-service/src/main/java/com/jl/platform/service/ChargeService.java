/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
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

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Charge>>
	 */
	public Result<Pagination<Charge>> pageQery(PageQuery pageQuery);

	/**
	 * @param id
	 * @return Result<Pagination<Charge>>
	 */
	public Result delete(String id);

	/**
	 * @param charge
	 * @return Result
	 */
	public Result update(Charge charge);

}
