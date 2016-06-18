package com.jl.platform.web.controller.api.admin;

import com.jl.platform.common.Result;
import com.jl.platform.service.StaffService;
import com.jl.platform.common.PageQuery;
import com.jl.platform.service.model.Staff;
import com.jl.platform.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by lishoubo on 16/5/21.
 */
@RestController
@RequestMapping("/api/admin")
public class StaffController extends BaseController {
    @Resource
    private StaffService staffService;

    @RequestMapping(value = "/staffs", method = RequestMethod.POST)
    public Result<String> addStaff(@Valid Staff staff) {
        Result<String> result = staffService.save(staff);
        return result;
    }

    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public Result list(PageQuery pageReq) {
        return staffService.query(pageReq);
    }

}
