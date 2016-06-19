package com.jl.platform.web.controller.api.admin;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.BuildingService;
import com.jl.platform.service.model.Building;
import com.jl.platform.web.controller.BaseController;

/**
 * @author zhanglu
 */
@RestController
@RequestMapping("/api/admin")
public class BuildingController extends BaseController {
	@Resource
	private BuildingService buildingService;

	@RequestMapping(value = "/building", method = RequestMethod.POST)
	public Result<String> add(@Valid Building building) {
		Result<String> result = buildingService.save(building);
		return result;
	}

	@RequestMapping(value = "/building", method = RequestMethod.GET)
	public Result<Pagination<Building>> listPage(PageQuery pageQuery) {
		return buildingService.query(pageQuery);

	}

	@RequestMapping(value = "/building/queryById", method = RequestMethod.GET)
	public Result<Building> queryById(@RequestParam("id") String id) {
		return buildingService.queryById(id);
	}

	@RequestMapping(value = "/building/update", method = RequestMethod.POST)
	public Result<String> update(@Valid Building building) {
		return buildingService.update(building);
	}
}
