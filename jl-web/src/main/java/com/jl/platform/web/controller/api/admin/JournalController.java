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
import com.jl.platform.service.JournalService;
import com.jl.platform.service.form.JournalForm;
import com.jl.platform.service.form.UpdateJournalForm;
import com.jl.platform.web.controller.BaseController;

/**
 * Created by lishoubo on 16/6/18.
 */
@RestController
@RequestMapping("/api/admin")
public class JournalController extends BaseController {
	@Resource
	private JournalService journalService;

	@RequestMapping(value = "/journal", method = RequestMethod.POST)
	public Result<String> add(@Valid @RequestBody JournalForm journalForm) {
		Result<String> result = journalService.save(journalForm);
		return result;
	}

	@RequestMapping(value = "/journal", method = RequestMethod.GET)
	public Result list(PageQuery pageReq) {
		return journalService.pageQery(pageReq);
	}

	@RequestMapping(value = "/journal/delete", method = RequestMethod.POST)
	public Result delete(@RequestParam("id") String id) {
		return journalService.delete(id);
	}

	@RequestMapping(value = "/journal/update", method = RequestMethod.POST)
	public Result delete(@Valid @RequestBody UpdateJournalForm updateJournalForm) {
		return journalService.update(updateJournalForm);
	}

}
