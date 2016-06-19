package com.jl.platform.domain.couchdb;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Journal;
import org.springframework.stereotype.Service;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service
public class JournalCouchDBStore extends CouchDBStore<Journal> {
    private static final String VIEW_ID_LIST = "baike/list";

    public Result<Pagination<Journal>> list(PageQuery pageQuery) {
        return pageQuery0(VIEW_ID_LIST, pageQuery, Journal.class, true);
    }
}
