package com.my.home.web.controller.admin;

import com.my.home.common.Result;
import com.my.home.common.StatusCode;
import com.my.home.service.StaffStoreService;
import com.my.home.service.model.Staff;
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
public class AdminController {
    @Resource
    private StaffStoreService staffStoreService;

    @RequestMapping("/articles")
    public Result addArticle() {
        return Result.result(StatusCode.SUCCESS);
    }

    @RequestMapping(value = "/staffs", method = RequestMethod.POST)
    public Result addStaff(Staff staff) {
        return staffStoreService.saveStaff(staff);
    }

    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public Result loadStaff(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "20") int pageSize) {
        return staffStoreService.queryPages(currentPage, pageSize);
    }

}
