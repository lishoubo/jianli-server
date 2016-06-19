package com.jl.platform.web.controller.api.admin;

import com.jl.platform.common.Result;
import com.jl.platform.service.BuildingService;
import com.jl.platform.service.model.Building;
import com.jl.platform.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author zhanglu
 */
@RestController
@RequestMapping("/api/admin")
public class BuildingController extends BaseController {
    @Resource
    private BuildingService buildingService;

    @RequestMapping(value = "/building", method = RequestMethod.POST)
    public Result<String> add(@Valid Building building) {
        Result<String> result = buildingService.save(building);
        return result;
    }

}
