package com.jl.platform.domain;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.BuildingService;
import com.jl.platform.service.model.Baike;

/**
 * Created by lishoubo on 16/6/19.
 */
public class BuildingServiceImpl implements BuildingService {
    @Override
    public Result<String> save(Baike baike) {
        return null;
    }

    @Override
    public Result<Pagination<Baike>> query(PageQuery pageQuery) {
        return null;
    }
}
