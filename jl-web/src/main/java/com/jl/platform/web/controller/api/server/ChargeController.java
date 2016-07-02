/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.web.controller.api.server;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public Result save(Charge charge) {
		return chargeService.save(charge);
	}
}
