package com.jl.platform.domain.mongodb;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Staff;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service
public class StaffMongoDBStore extends MongoDBStore<Staff> {

	public Result<Pagination<Staff>> pageQuery(PageQuery pageQuery) {
		return pageQuery0(pageQuery);
	}

	public Result<Staff> findByName(String name) {
		return find("name", name);
	}

	public Result<Staff> queryById(String id) {
		return find(ID, id);
	}

}
