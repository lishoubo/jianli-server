/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.domain.mongodb;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Baike;

/**
 * @author zhanglu
 */
@Service
public class BaikeMongoDBStore extends MongoDBStore<Baike> {

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Baike>>
	 */
	public Result<Pagination<Baike>> pageQuery(PageQuery pageQuery) {
		return pageQuery0(pageQuery);
	}

	/**
	 * @param id
	 * @return Result
	 */
	public Result find(String id) {
		return find(ID, id);
	}

}
