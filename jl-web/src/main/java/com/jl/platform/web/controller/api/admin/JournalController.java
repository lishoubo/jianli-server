package com.jl.platform.web.controller.api.admin;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Result;
import com.jl.platform.form.JournalForm;
import com.jl.platform.service.JournalService;
import com.jl.platform.web.controller.BaseController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
        return journalService.pageQuery(pageReq);
    }

    @RequestMapping(value = "/journal/queryById", method = RequestMethod.GET)
    public Result queryById(@RequestParam("id") String id) {
        return journalService.queryById(id);
    }

    @RequestMapping(value = "/journal/delete", method = RequestMethod.POST)
    public Result delete(@RequestParam("id") String id) {
        return journalService.delete(id);
    }

    @RequestMapping(value = "/journal/update", method = RequestMethod.POST)
    public Result delete(@Valid @RequestBody JournalForm journalForm) {
        return journalService.update(journalForm);
    }

}
