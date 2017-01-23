package com.jl.platform.service.impl;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.dao.model.Building;
import com.jl.platform.dao.mongo.BuildingDao;
import com.jl.platform.dao.mongo.StaffDao;
import com.jl.platform.form.BuildingForm;
import com.jl.platform.service.BuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lishoubo on 16/6/19.
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
    @Resource
    private BuildingDao buildingDao;

    @Resource
    private StaffDao staffDao;

    @Override
    public Result<String> save(BuildingForm buildingForm) {
        return buildingDao.save(new Building());

    }

    @Override
    public Result<Pagination<Building>> pageQuery(PageQuery pageQuery) {
        return buildingDao.pageQuery(pageQuery);
    }

    @Override
    public Result<Building> queryById(String id) {
        Result<Building> result = buildingDao.queryById(id);

        if (result.getCode() == StatusCode.RECORD_NOT_FOUND.getCode()) {
            return Result.create(StatusCode.BUILDING_NOT_FOUND);
        }

        return result;
    }

    @Override
    public Result update(BuildingForm buildingForm) {
        return buildingDao.update(new Building());
    }

    @Override
    public Result delete(String id) {
        return buildingDao.delete(id);
    }
}
