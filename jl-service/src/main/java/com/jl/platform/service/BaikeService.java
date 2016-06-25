package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Baike;
import com.jl.platform.service.model.BaikeQueryCondition;

public interface BaikeService {

	Result<String> save(Baike baike);

	Result<Pagination<Baike>> pageQuery(PageQuery pageQuery);

	/**
	 * @param id
	 * @return Result
	 */
	Result queryById(String id);

	/**
	 * @param id
	 * @return Result
	 */
	Result delete(String id);

	/**
	 * @param baike
	 * @return Result
	 */
	Result update(Baike baike);

	/**
	 * @param condition
	 * @return Result
	 */
	Result queryByCondition(BaikeQueryCondition condition);
}
