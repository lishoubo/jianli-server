package com.jl.platform.web.controller.api.admin;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Result;
import com.jl.platform.service.BaikeService;
import com.jl.platform.service.model.Baike;
import com.jl.platform.service.model.BaikeQueryCondition;
import com.jl.platform.web.controller.BaseController;

/**
 * Created by lishoubo on 16/6/18.
 */
@RestController
@RequestMapping("/api/admin")
public class BaikeController extends BaseController {
	@Resource
	private BaikeService baikeService;

	@RequestMapping(value = "/baike", method = RequestMethod.POST)
	public Result<String> add(Baike baike) {
		Result<String> result = baikeService.save(baike);
		return result;
	}

	@RequestMapping(value = "/baike", method = RequestMethod.GET)
	public Result list(PageQuery pageReq) {
		return baikeService.pageQuery(pageReq);
	}

	@RequestMapping(value = "/baike/queryById", method = RequestMethod.GET)
	public Result queryById(@RequestParam("id") String id) {
		return baikeService.queryById(id);
	}

	@RequestMapping(value = "/baike/queryByCondition", method = RequestMethod.POST)
	public Result queryByCondition(BaikeQueryCondition condition) {
		return baikeService.queryByCondition(condition);
	}

	@RequestMapping(value = "/baike/delete", method = RequestMethod.POST)
	public Result delete(@RequestParam("id") String id) {
		return baikeService.delete(id);
	}

	@RequestMapping(value = "/baike/update", method = RequestMethod.POST)
	public Result update(Baike baike) {
		return baikeService.update(baike);
	}

}
