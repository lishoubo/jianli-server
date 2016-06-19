package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Building;

public interface BuildingService {

	Result<String> save(Building building);

	Result<Pagination<Building>> query(PageQuery pageQuery);

	/**
	 * @param id
	 * @return Result<Building>
	 */
	Result<Building> queryById(String id);

	/**
	 * @param building
	 * @return Result<String>
	 */
	Result<String> update(Building building);
}
