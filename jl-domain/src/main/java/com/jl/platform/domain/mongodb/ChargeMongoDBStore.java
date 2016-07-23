/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.domain.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Charge>>
	 */
	public Result<Pagination<Charge>> pageQuery(PageQuery pageQuery) {

		return pageQuery1(pageQuery);
	}

}
