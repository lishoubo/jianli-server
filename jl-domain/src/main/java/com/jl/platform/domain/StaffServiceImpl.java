package com.jl.platform.domain;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.domain.mongodb.StaffMongoDBStore;
import com.jl.platform.service.StaffService;
import com.jl.platform.service.model.Staff;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

	@Resource
	private StaffMongoDBStore staffMongoDBStore;

	@Override
	public Result<String> save(Staff staff) {
		staff.setCreateDate(new Date());
		staff.setUpdateDate(new Date());
		Result responseResult = staffMongoDBStore.save(staff);
		if (!responseResult.isSuccess()) {
			return Result.create(responseResult.getCode(),
					responseResult.getMessage());
		}
		return Result.create(responseResult.getData());
	}

	@Override
	public Result<Pagination<Staff>> query(PageQuery pageQuery) {
		return staffMongoDBStore.pageQuery(pageQuery);
	}

	@Override
	public Result<Staff> queryByName(String name) {
		return staffMongoDBStore.findByName(name);
	}

	@Override
	public Result queryById(String id) {
		return staffMongoDBStore.queryById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.StaffService#delete(java.lang.String)
	 */
	@Override
	public Result delete(String id) {
		return staffMongoDBStore.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jl.platform.service.StaffService#update(com.jl.platform.service.model
	 * .Staff)
	 */
	@Override
	public Result update(Staff staff) {
		staff.setUpdateDate(new Date());
		return staffMongoDBStore.update(staff);
	}
}
