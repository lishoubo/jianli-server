package com.jl.platform.web.controller.api.server;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Result;
import com.jl.platform.service.JournalService;
import com.jl.platform.web.controller.BaseController;

/**
 * Created by lishoubo on 16/6/18.
 */
@RestController
@RequestMapping("/api/server")
public class JournalQueryController extends BaseController {
	@Resource
	private JournalService journalService;

	@RequestMapping(value = "/journal", method = RequestMethod.GET)
	public Result list(PageQuery pageReq) {
		return journalService.pageQuery(pageReq);
	}

	@RequestMapping(value = "/journal/queryById", method = RequestMethod.GET)
	public Result queryById(@RequestParam("id") String id) {
		return journalService.queryById(id);
	}
}
