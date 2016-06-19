package com.jl.platform.domain;

import javax.annotation.Resource;

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
		Staff staff = staffCouchDBStore.find(building.getStaffName());
		if (staff == null) {
			return Result.create(StatusCode.NOT_FOUND_STAFF);
		}

		Result<Response> responseResult = buildingCouchDBStore.save(building);

		return Result.create(responseResult.getData().getId());
	}

	@Override
	public Result<Pagination<Building>> query(PageQuery pageQuery) {
		return buildingCouchDBStore.queryPage(pageQuery);
	}
}
