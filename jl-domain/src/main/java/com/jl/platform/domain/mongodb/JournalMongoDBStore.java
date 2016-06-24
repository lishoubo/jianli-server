/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.domain.mongodb;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Journal;

/**
 * @author zhanglu
 */
@Service
public class JournalMongoDBStore extends MongoDBStore<Journal> {

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Journal>>
	 */
	public Result<Pagination<Journal>> pageQery(PageQuery pageQuery) {
		return pageQuery0(pageQuery);
	}

}
