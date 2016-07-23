package com.jl.platform.web.controller.api.server;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Result;
import com.jl.platform.service.StaffService;
import com.jl.platform.web.controller.BaseController;

/**
 * Created by lishoubo on 16/5/21.
 */
@RestController
@RequestMapping("/api/server")
public class StaffQueryController extends BaseController {
	@Resource
	private StaffService staffService;

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

}
