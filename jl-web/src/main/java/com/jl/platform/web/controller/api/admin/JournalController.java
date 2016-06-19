package com.jl.platform.web.controller.api.admin;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Result;
import com.jl.platform.service.BaikeService;
import com.jl.platform.service.JournalService;
import com.jl.platform.service.form.JournalForm;
import com.jl.platform.service.model.Baike;
import com.jl.platform.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by lishoubo on 16/6/18.
 */
@RestController
@RequestMapping("/api/admin/journal")
public class JournalController extends BaseController {
    @Resource
    private JournalService journalService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result<String> add(@Valid JournalForm journalForm) {
        Result<String> result = journalService.save(journalForm);
        return result;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result list(PageQuery pageReq) {
        return journalService.query(pageReq);
    }

}
