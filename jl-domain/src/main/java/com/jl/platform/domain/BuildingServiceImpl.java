package com.jl.platform.domain;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.domain.mongodb.BuildingMongoDBStore;
import com.jl.platform.domain.mongodb.StaffMongoDBStore;
import com.jl.platform.service.BuildingService;
import com.jl.platform.service.model.Building;
import com.jl.platform.service.model.Staff;

/**
 * Created by lishoubo on 16/6/19.
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
	@Resource
	private BuildingMongoDBStore buildingMongoDBStore;

	@Resource
	private StaffMongoDBStore staffMongoDBStore;

	@Override
	public Result<String> save(Building building) {
		if (StringUtils.isNoneBlank(building.getStaff())) {
			Result<Staff> staffResult = staffMongoDBStore.findByName(building
					.getStaff());
			if (staffResult == null || !staffResult.isSuccess()
					|| staffResult.getData() == null) {
				return Result.create(StatusCode.STAFF_NOT_FOUND);
			}
		}

		building.setCreateDate(String.valueOf(new Date().getTime()));
		return buildingMongoDBStore.save(building);

	}

	@Override
	public Result<Pagination<Building>> pageQuery(PageQuery pageQuery) {

		return buildingMongoDBStore.pageQuery(pageQuery);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.BuildingService#queryById(java.lang.String)
	 */
	@Override
	public Result<Building> queryById(String id) {
		return buildingMongoDBStore.queryById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jl.platform.service.BuildingService#update(com.jl.platform.service
	 * .model.Building)
	 */
	@Override
	public Result update(Building building) {
		building.setUpdateDate(String.valueOf(new Date().getTime()));
		return buildingMongoDBStore.update(building);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.BuildingService#delete(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Result delete(String id) {
		return buildingMongoDBStore.delete(id);
	}
}
