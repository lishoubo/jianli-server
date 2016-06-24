package com.jl.platform.domain.mongodb;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.domain.couchdb.CouchDBStore;
import com.jl.platform.service.model.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service
public class StaffMongoDBStore extends MongoDBStore<Staff> {

    public Result<Pagination<Staff>> pageQuery(PageQuery pageQuery) {
        return Result.create(StatusCode.SYSTEM_ERROR);
    }

    public Staff find(String name) {
        return null;
    }

}
