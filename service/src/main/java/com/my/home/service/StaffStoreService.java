package com.my.home.service;

import java.util.List;

import com.my.home.common.Result;
import com.my.home.service.model.Staff;
import com.my.home.service.model.common.PageQueryRequest;
import com.my.home.service.model.common.PageResult;

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
