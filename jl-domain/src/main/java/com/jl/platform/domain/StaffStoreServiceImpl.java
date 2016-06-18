package com.jl.platform.domain;

import com.jl.platform.common.PagedResult;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.service.StaffStoreService;
import com.jl.platform.service.form.PageQuery;
import com.jl.platform.service.model.Staff;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("staffStoreService")
public class StaffStoreServiceImpl implements StaffStoreService {
    @Resource
    private CouchDbClient couchDbClient;

    @Override
    public Result<String> save(Staff staff) {
        Response response = null;
        try {
            response = couchDbClient.save(staff);
        } catch (Exception e) {
            return new Result<>(StatusCode.SYSTEM_ERROR);
        }

        return new Result<String>(response.getId());
    }

    @Override
    public PagedResult<List<Staff>> query(PageQuery pageQuery) {
        List<Staff> staffs = couchDbClient.view("staff/queryPage")
                .includeDocs(true).skip(pageQuery.getPage() - 1)
                .limit(pageQuery.getPageSize()).query(Staff.class);

        PagedResult<List<Staff>> result = new PagedResult<List<Staff>>(staffs);
        result.setPageSize(pageQuery.getPageSize());
        return result;
    }
}
