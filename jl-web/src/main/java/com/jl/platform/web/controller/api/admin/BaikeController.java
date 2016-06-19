package com.jl.platform.web.controller.api.admin;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Result;
import com.jl.platform.service.BaikeService;
import com.jl.platform.service.model.Baike;
import com.jl.platform.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lishoubo on 16/6/18.
 */
@RestController
@RequestMapping("/api/admin/baike")
public class BaikeController extends BaseController {
    @Resource
    private BaikeService baikeService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result<String> add(Baike baike) {
        Result<String> result = baikeService.save(baike);
        return result;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result list(PageQuery pageReq) {
        return baikeService.query(pageReq);
    }

}
