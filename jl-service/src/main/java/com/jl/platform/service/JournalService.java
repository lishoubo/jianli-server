package com.jl.platform.service;

import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.PageQuery;
import com.jl.platform.service.model.Baike;

public interface JournalService {

    Result<String> save(Baike baike);

    Result<Pagination<Baike>> query(PageQuery pageQuery);
}
