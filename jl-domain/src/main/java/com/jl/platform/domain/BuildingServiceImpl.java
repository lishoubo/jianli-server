package com.jl.platform.domain;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.domain.couchdb.BuildingCouchDBStore;
import com.jl.platform.domain.couchdb.StaffCouchDBStore;
import com.jl.platform.service.BuildingService;
import com.jl.platform.service.model.Building;
import com.jl.platform.service.model.Staff;

/**
 * Created by lishoubo on 16/6/19.
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
	@Resource
	private BuildingCouchDBStore buildingCouchDBStore;

	@Resource
	private StaffCouchDBStore staffCouchDBStore;

	@Override
	public Result<String> save(Building building) {
		if (StringUtils.isNoneBlank(building.getStaffName())) {
			Staff staff = staffCouchDBStore.find(building.getStaffName());
			if (staff == null) {
				return Result.create(StatusCode.NOT_FOUND_STAFF);
			}
		}

		Result<Response> responseResult = buildingCouchDBStore.save(building);

		return Result.create(responseResult.getData().getId());
	}

	@Override
	public Result<Pagination<Building>> query(PageQuery pageQuery) {

		Result<Pagination<Building>> paginationResult = buildingCouchDBStore.queryPage(pageQuery);
		return paginationResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.BuildingService#queryById(java.lang.String)
	 */
	@Override
	public Result<Building> queryById(String id) {
		Building building = buildingCouchDBStore.queryById(id);

		return Result.create(building);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jl.platform.service.BuildingService#update(com.jl.platform.service
	 * .model.Building)
	 */
	@Override
	public Result<String> update(Building building) {
		Result<Response> responseResult = buildingCouchDBStore.update(building);
		return Result.create(responseResult.getData().getId());
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.BuildingService#delete(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Result<String> delete(String id, String rev) {
		Result<Response> responseResult = buildingCouchDBStore.delete(id, rev);
		return Result.create(responseResult.getData().getId());
	}
}
