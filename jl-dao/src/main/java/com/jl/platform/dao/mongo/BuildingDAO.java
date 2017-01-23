/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.dao.mongo;

import com.jl.platform.common.Result;
import com.jl.platform.dao.model.Building;
import org.springframework.stereotype.Component;

@Component
public class BuildingDao extends MongoDBStore<Building> {


	public Result<Building> queryById(String id) {
		return find(ID, id);
	}

	public Result<Building> findByName(String buildingName) {
		return find("name", buildingName);
	}
}
