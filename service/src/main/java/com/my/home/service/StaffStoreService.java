package com.my.home.service;

import com.my.home.common.Result;
import com.my.home.service.model.Staff;

public interface StaffStoreService {
	Result saveStaff(Staff staff);

	Result queryPages(int currentPage, int pageSize);
}
