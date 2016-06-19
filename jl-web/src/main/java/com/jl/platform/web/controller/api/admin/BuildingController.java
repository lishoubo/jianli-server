/**
 * guanyuhuhu 2016年6月19日
 */
package com.jl.platform.web.controller.api.admin;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jl.platform.common.Result;
import com.jl.platform.service.BuildingService;
import com.jl.platform.service.model.Building;
import com.jl.platform.web.controller.BaseController;

/**
 * @author zhanglu
 */
@Controller
@RequestMapping("/api/admin/building")
public class BuildingController extends BaseController {
	@Resource
	private BuildingService buildingService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Result<String> add(@Valid Building building) {
		Result<String> result = buildingService.save(building);
		return result;
	}

}
