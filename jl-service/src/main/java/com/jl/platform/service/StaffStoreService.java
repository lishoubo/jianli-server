package com.jl.platform.service;

import java.util.List;

import com.jl.platform.service.model.Staff;
import com.jl.platform.common.PagedResult;
import com.jl.platform.common.Result;
import com.jl.platform.service.form.PageQuery;

public interface StaffStoreService {
	/**
	 * 创建一个新的员工
	 * 
	 * @param staff
	 * @return Result<String>
	 */
	Result<String> save(Staff staff);

	/**
	 * 分页查询员工信息
	 * 
	 * @param pageQuery
	 * @return Result
	 */
	PagedResult<List<Staff>> query(PageQuery pageQuery);
}
