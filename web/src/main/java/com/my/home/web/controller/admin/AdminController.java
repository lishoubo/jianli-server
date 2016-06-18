package com.my.home.web.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.home.common.Result;
import com.my.home.common.StatusCode;
import com.my.home.service.StaffStoreService;
import com.my.home.service.model.Staff;
import com.my.home.service.model.common.PageQueryRequest;
import com.my.home.web.controller.common.BaseController;
import com.my.home.web.controller.common.RunnableService;

/**
 * Created by lishoubo on 16/5/21.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController extends BaseController {
	@Resource
	private StaffStoreService staffStoreService;

	@RequestMapping("/articles")
	public Result<Void> addArticle() {
		return new Result(StatusCode.SUCCESS);
	}

	@RequestMapping(value = "/staffs", method = RequestMethod.POST)
	public Result<String> addStaff(final Staff staff) {
		Result<String> result = serviceTemplate
				.executeWithoutTransaction(new RunnableService<String>() {

					@Override
					public Result<String> run() {
						return staffStoreService.saveStaff(staff);
					}
				});

		return result;
	}

	@RequestMapping(value = "/staffs", method = RequestMethod.GET)
	public Result loadStaff(
			@RequestParam("pageReq") final PageQueryRequest pageReq) {
		Result<List<Staff>> result = serviceTemplate
				.executeWithoutTransaction(new RunnableService<List<Staff>>() {

					@Override
					public Result<List<Staff>> run() {
						return staffStoreService.queryPages(pageReq);
					}
				});

		return result;
	}

}
