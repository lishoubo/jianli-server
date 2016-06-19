package com.jl.platform.domain.couchdb;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Staff;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service
public class StaffCouchDBStore extends CouchDBStore<Staff> {
	private static final String VIEW_ID_LIST = "staff/list";

	public Result<Pagination<Staff>> pageQuery(PageQuery pageQuery) {
		return pageQuery0(VIEW_ID_LIST, pageQuery, Staff.class, true);
	}

	public Staff find(String name) {
		List<Staff> staffs = listQuery0(VIEW_ID_LIST, Staff.class, 1, name);
		return staffs == null ? null : staffs.get(0);
	}

}
