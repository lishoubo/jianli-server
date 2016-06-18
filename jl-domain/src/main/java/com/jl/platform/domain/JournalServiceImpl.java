package com.jl.platform.domain;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.domain.couchdb.BaikeCouchDBStore;
import com.jl.platform.service.BaikeService;
import com.jl.platform.service.model.Baike;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service("baikeService")
public class JournalServiceImpl implements BaikeService {
    @Resource
    private BaikeCouchDBStore baikeCouchDBStore;

    @Override
    public Result<String> save(Baike baike) {
        Result<Response> result = baikeCouchDBStore.save(baike);
        if (!result.isSuccess()) {
            return Result.create(result.getCode(), result.getMessage());
        }
        return Result.create(result.getData().getId());
    }

    @Override
    public Result<Pagination<Baike>> query(PageQuery pageQuery) {
        return baikeCouchDBStore.list(pageQuery);
    }
}
