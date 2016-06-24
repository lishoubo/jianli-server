package com.jl.platform.domain;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.domain.mongodb.BaikeMongoDBStore;
import com.jl.platform.service.BaikeService;
import com.jl.platform.service.model.Baike;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service("baikeService")
public class BaikeServiceImpl implements BaikeService {
	@Resource
	private BaikeMongoDBStore baikeMongoDBStore;

	@Override
	public Result<String> save(Baike baike) {
		Result<String> result = baikeMongoDBStore.save(baike);
		if (!result.isSuccess()) {
			return Result.create(result.getCode(), result.getMessage());
		}
		return Result.create(result.getData());
	}

	@Override
	public Result<Pagination<Baike>> pageQuery(PageQuery pageQuery) {
		return baikeMongoDBStore.pageQuery(pageQuery);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.BaikeService#queryById(java.lang.String)
	 */
	@Override
	public Result queryById(String id) {
		return baikeMongoDBStore.find(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.BaikeService#delete(java.lang.String)
	 */
	@Override
	public Result delete(String id) {
		return baikeMongoDBStore.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jl.platform.service.BaikeService#update(com.jl.platform.service.model
	 * .Baike)
	 */
	@Override
	public Result update(Baike baike) {
		return baikeMongoDBStore.update(baike);
	}
}
