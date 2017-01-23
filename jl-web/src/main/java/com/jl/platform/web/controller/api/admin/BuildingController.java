package com.jl.platform.web.controller.api.admin;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.dao.model.Building;
import com.jl.platform.form.BuildingForm;
import com.jl.platform.service.BuildingService;
import com.jl.platform.web.controller.BaseController;
import org.springframework.web.bind.annotation.*;

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
    public Result<String> add(@Valid @RequestBody BuildingForm building) {
        Result<String> result = buildingService.save(building);
        return result;
    }

    @RequestMapping(value = "/building", method = RequestMethod.GET)
    public Result<Pagination<Building>> listPage(PageQuery pageQuery) {
        return buildingService.pageQuery(pageQuery);

    }

    @RequestMapping(value = "/building/queryById", method = RequestMethod.GET)
    public Result<Building> queryById(@RequestParam("id") String id) {
        return buildingService.queryById(id);
    }

    @RequestMapping(value = "/building/update", method = RequestMethod.POST)
    public Result<String> update(@Valid @RequestBody BuildingForm building) {
        return buildingService.update(building);
    }

    @RequestMapping(value = "/building/delete", method = RequestMethod.POST)
    public Result<String> delete(@RequestParam("id") String id) {
        return buildingService.delete(id);
    }
}
