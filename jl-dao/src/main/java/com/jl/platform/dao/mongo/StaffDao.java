package com.jl.platform.dao.mongo;

import com.jl.platform.common.Result;
import com.jl.platform.dao.model.Staff;
import org.springframework.stereotype.Component;

/**
 * Created by lishoubo on 16/6/18.
 */
@Component
public class StaffDao extends MongoDBStore<Staff> {

    public Result<Staff> findByName(String name) {
        return find("name", name);
    }

    public Result<Staff> queryById(String id) {
        return find(ID, id);
    }

}
