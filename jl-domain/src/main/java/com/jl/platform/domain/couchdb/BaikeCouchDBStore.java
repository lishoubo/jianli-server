package com.jl.platform.domain.couchdb;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Baike;
import org.springframework.stereotype.Service;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service
public class BaikeCouchDBStore extends CouchDBStore<Baike> {
    private static final String VIEW_ID_LIST = "baike/list";

    public Result<Pagination<Baike>> list(PageQuery pageQuery) {
        return pageQuery0(VIEW_ID_LIST, pageQuery, Baike.class, true);
    }
}
