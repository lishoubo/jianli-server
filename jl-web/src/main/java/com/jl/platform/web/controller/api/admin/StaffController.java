package com.jl.platform.web.controller.api.admin;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Result;
import com.jl.platform.service.StaffService;
import com.jl.platform.service.model.Staff;
import com.jl.platform.web.controller.BaseController;

/**
 * Created by lishoubo on 16/5/21.
 */
@RestController
@RequestMapping("/api/admin")
public class StaffController extends BaseController {
	@Resource
	private StaffService staffService;

	@RequestMapping(value = "/staffs", method = RequestMethod.POST)
	public Result<String> addStaff(@Valid @RequestBody Staff staff) {
		Result<String> result = staffService.save(staff);
		return result;
	}

	@RequestMapping(value = "/staffs", method = RequestMethod.GET)
	public Result list(PageQuery pageReq) {
		return staffService.query(pageReq);
	}

	@RequestMapping(value = "/staffs/queryByName", method = RequestMethod.GET)
	public Result queryStaffByName(@RequestParam("name") String name) {
		return staffService.queryByName(name);

	}

	@RequestMapping(value = "/staffs/queryById", method = RequestMethod.GET)
	public Result queryStaffById(@RequestParam("id") String id) {
		return staffService.queryById(id);

	}

	@RequestMapping(value = "/staffs/delete", method = RequestMethod.POST)
	public Result delete(@RequestParam("id") String id) {
		return staffService.delete(id);
	}

	@RequestMapping(value = "/staffs/update", method = RequestMethod.POST)
	public Result update(Staff staff) {
		return staffService.update(staff);
	}

}
