package com.jl.platform.domain;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.domain.couchdb.CouchDBStore;
import com.jl.platform.service.StaffStoreService;
import com.jl.platform.service.model.Staff;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("staffStoreService")
public class StaffStoreServiceImpl implements StaffStoreService {
    @Resource
    private CouchDBStore couchDBStore;

    @Override
    public Result<String> save(Staff staff) {
        Result<Response> responseResult = couchDBStore.save(staff);
        if (!responseResult.isSuccess()) {
            return Result.create(responseResult.getCode(), responseResult.getMessage());
        }
        return Result.create(responseResult.getData().getId());
    }

    @Override
    public Result<Pagination<Staff>> query(PageQuery pageQuery) {
        List<Staff> staffs = couchDBStore.pageQuery(pageQuery);
        return Result.pagination(staffs, pageQuery, 10);
    }
}
