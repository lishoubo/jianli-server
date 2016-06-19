package com.jl.platform.domain;

import javax.annotation.Resource;

import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.domain.couchdb.StaffCouchDBStore;
import com.jl.platform.service.StaffService;
import com.jl.platform.service.model.Staff;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
	@Resource
	private StaffCouchDBStore staffCouchDBStore;

	@Override
	public Result<String> save(Staff staff) {
		Result<Response> responseResult = staffCouchDBStore.save(staff);
		if (!responseResult.isSuccess()) {
			return Result.create(responseResult.getCode(),
					responseResult.getMessage());
		}
		return Result.create(responseResult.getData().getId());
	}

	@Override
	public Result<Pagination<Staff>> query(PageQuery pageQuery) {
		return staffCouchDBStore.pageQuery(pageQuery);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.StaffService#queryByTitle(java.lang.String)
	 */
	@Override
	public Result queryByName(String name) {
		Staff staff = staffCouchDBStore.find(name);

		return Result.create(staff);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.StaffService#queryById(java.lang.String)
	 */
	@Override
	public Result queryById(String id) {
		Staff staff = staffCouchDBStore.queryById(id);

		return Result.create(staff);
	}
}
