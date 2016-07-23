/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.web.controller.api.server;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.ChargeService;
import com.jl.platform.service.model.Charge;
import com.jl.platform.web.controller.BaseController;

/**
 * @author zhanglu
 */
@RestController
@RequestMapping("/api/server/")
public class ChargeController extends BaseController {
	@Resource
	private ChargeService chargeService;

	@RequestMapping(value = "/charge", method = RequestMethod.POST)
	public Result save(@Valid @RequestBody Charge charge) {
		return chargeService.save(charge);
	}

	@RequestMapping(value = "/charge", method = RequestMethod.GET)
	public Result<Pagination<Charge>> listPage(PageQuery pageQuery) {
		return chargeService.pageQery(pageQuery);
	}

	@RequestMapping(value = "/charge/count", method = RequestMethod.GET)
	public void count() {
		// return chargeService.count();
	}

	@RequestMapping(value = "/charge/delete", method = RequestMethod.POST)
	public Result delete(@RequestParam String id) {
		return chargeService.delete(id);
	}

	@RequestMapping(value = "/charge/update", method = RequestMethod.POST)
	public Result delete(@Valid @RequestBody Charge charge) {
		return chargeService.update(charge);
	}
}
