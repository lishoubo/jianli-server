package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Staff;

public interface StaffService {
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
	Result<Pagination<Staff>> query(PageQuery pageQuery);

	/**
	 * @param name
	 * @return Result
	 */
	Result queryByName(String name);
}
