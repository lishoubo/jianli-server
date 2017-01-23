package com.jl.platform.service.impl;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.dao.model.Staff;
import com.jl.platform.dao.mongo.StaffDao;
import com.jl.platform.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

	@Resource
	private StaffDao staffDao;

	@Override
	public Result<String> save(Staff staff) {
		return null;
	}

	@Override
	public Result<Pagination<Staff>> query(PageQuery pageQuery) {
		return null;
	}

	@Override
	public Result queryById(String id) {
		return null;
	}

	@Override
	public Result<Staff> queryByName(String name) {
		return null;
	}

	@Override
	public Result delete(String id) {
		return null;
	}

	@Override
	public Result update(Staff staff) {
		return null;
	}
}
