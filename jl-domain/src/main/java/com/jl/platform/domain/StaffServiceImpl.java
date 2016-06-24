package com.jl.platform.domain;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.domain.mongodb.StaffMongoDBStore;
import com.jl.platform.service.StaffService;
import com.jl.platform.service.model.Staff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffMongoDBStore staffMongoDBStore;

    @Override
    public Result<String> save(Staff staff) {
        Result responseResult = staffMongoDBStore.save(staff);
        if (!responseResult.isSuccess()) {
            return Result.create(responseResult.getCode(),
                    responseResult.getMessage());
        }
        return Result.create(responseResult.getData());
    }

    @Override
    public Result<Pagination<Staff>> query(PageQuery pageQuery) {
        return staffMongoDBStore.pageQuery(pageQuery);
    }

    @Override
    public Result<Staff> queryByName(String name) {
        return staffMongoDBStore.findByName(name);
    }

    @Override
    public Result queryById(String id) {
        return staffMongoDBStore.queryById(id);
    }
}
