/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.domain.mongodb;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Building;

/**
 * @author zhanglu
 */
@Service
public class BuildingMongoDBStore extends MongoDBStore<Building> {

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Building>>
	 */
	public Result<Pagination<Building>> pageQuery(PageQuery pageQuery) {
		return pageQuery0(pageQuery);
	}

	/**
	 * @param id
	 * @return Building
	 */
	public Result<Building> queryById(String id) {
		return find(ID, id);
	}
}
