package com.jl.platform.domain.couchdb;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Building;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service
public class BuildingCouchDBStore extends CouchDBStore<Building> {
	private static final String VIEW_ID_LIST = "building/list";

	public Result<Pagination<Building>> list(PageQuery pageQuery) {
		return pageQuery0(VIEW_ID_LIST, pageQuery, Building.class, true);
	}

	public Building find(String name) {
		List<Building> buildings = listQuery0(VIEW_ID_LIST, Building.class, 1,
				name);
		return buildings == null ? null : buildings.get(0);
	}

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Building>>
	 */
	public Result<Pagination<Building>> queryPage(PageQuery pageQuery) {
		return pageQuery0(VIEW_ID_LIST, pageQuery, Building.class, true);
	}
}
