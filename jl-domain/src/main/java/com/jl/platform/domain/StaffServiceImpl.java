package com.jl.platform.domain;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.domain.couchdb.StaffCouchDBStore;
import com.jl.platform.service.StaffService;
import com.jl.platform.service.model.Staff;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffCouchDBStore staffCouchDBStore;

    @Override
    public Result<String> save(Staff staff) {
        Result<Response> responseResult = staffCouchDBStore.save(staff);
        if (!responseResult.isSuccess()) {
            return Result.create(responseResult.getCode(), responseResult.getMessage());
        }
        return Result.create(responseResult.getData().getId());
    }

    @Override
    public Result<Pagination<Staff>> query(PageQuery pageQuery) {
        return staffCouchDBStore.list(pageQuery);
    }
}
