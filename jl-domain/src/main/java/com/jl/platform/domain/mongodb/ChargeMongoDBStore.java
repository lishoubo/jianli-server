/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.domain.mongodb;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Charge;

/**
 * @author zhanglu
 */
@Service
public class ChargeMongoDBStore extends MongoDBStore<Charge> {

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Charge>>
	 */
	public Result<Pagination<Charge>> pageQuery(PageQuery pageQuery) {
		return this.pageQuery0(pageQuery);
	}

}
