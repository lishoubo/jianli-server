package com.jl.platform.service;

import java.util.List;

import com.jl.platform.service.model.Staff;
import com.jl.platform.service.model.common.PageResult;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.common.PageQueryRequest;

public interface StaffStoreService {
	/**
	 * 创建一个新的员工
	 * 
	 * @param staff
	 * @return Result<String>
	 */
	Result<String> saveStaff(Staff staff);

	/**
	 * 分页查询员工信息
	 * 
	 * @param pageReq
	 * @return Result
	 */
	PageResult<List<Staff>> queryPages(PageQueryRequest pageReq);
}
