package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Baike;
import com.jl.platform.service.model.Building;

public interface BuildingService {

	Result<String> save(Building building);

	Result<Pagination<Baike>> query(PageQuery pageQuery);
}
