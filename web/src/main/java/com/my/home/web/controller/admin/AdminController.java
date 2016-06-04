package com.my.home.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.home.common.Result;
import com.my.home.common.StatusCode;
import com.my.home.service.StaffStoreService;
import com.my.home.service.model.Staff;

/**
 * Created by lishoubo on 16/5/21.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private StaffStoreService staffStoreService;

	@RequestMapping("/articles")
	public Result addArticle() {
		return Result.result(StatusCode.SUCCESS);
	}

	@RequestMapping(value = "/api/admin/staffs", method = RequestMethod.POST)
	public Result addStaff(Staff staff) {
		return staffStoreService.saveStaff(staff);
	}

	@RequestMapping(value = "/api/admin/staffs", method = RequestMethod.GET)
	public Result loadStaff(
			@RequestParam(value = "currentPage", required = false) int currentPage,
			@RequestParam(value = "pageSize", required = false) int pageSize) {
		return staffStoreService.queryPages(currentPage, pageSize);
	}

}
