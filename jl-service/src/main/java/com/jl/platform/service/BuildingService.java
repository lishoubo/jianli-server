package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.dao.model.Building;
import com.jl.platform.form.BuildingForm;

public interface BuildingService {

    Result<String> save(BuildingForm buildingForm);

    Result<Pagination<Building>> pageQuery(PageQuery pageQuery);

    Result<Building> queryById(String id);

    Result update(BuildingForm buildingForm);

    Result delete(String id);
}
