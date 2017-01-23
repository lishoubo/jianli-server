package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.dao.model.Staff;
import com.jl.platform.form.StaffForm;

public interface StaffService {
    Result<String> save(StaffForm staffForm);

    Result<Pagination<Staff>> query(PageQuery pageQuery);

    Result queryById(String id);

    Result<Staff> queryByName(String name);

    Result delete(String id);

    Result update(StaffForm staffForm);
}
