package com.jl.platform.web.controller.api.admin;

import com.jl.platform.common.Result;
import com.jl.platform.service.StaffStoreService;
import com.jl.platform.common.PageQuery;
import com.jl.platform.service.model.Staff;
import com.jl.platform.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lishoubo on 16/5/21.
 */
@RestController
@RequestMapping("/api/admin")
public class StaffController extends BaseController {
    @Resource
    private StaffStoreService staffStoreService;

    @RequestMapping(value = "/staffs", method = RequestMethod.POST)
    public Result<String> addStaff(Staff staff) {
        Result<String> result = staffStoreService.save(staff);
        return result;
    }

    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public Result list(PageQuery pageReq) {
        return staffStoreService.query(pageReq);
    }

}
