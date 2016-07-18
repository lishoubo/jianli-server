/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.domain;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.domain.mongodb.ChargeMongoDBStore;
import com.jl.platform.service.ChargeService;
import com.jl.platform.service.model.Charge;

/**
 * @author zhanglu
 */
@Service
public class ChargeServiceImpl implements ChargeService {
	@Resource
	private ChargeMongoDBStore chargeMongoDBStore;

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.ChargeService#save()
	 */
	@Override
	public Result save(Charge charge) {
		return chargeMongoDBStore.save(charge);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jl.platform.service.ChargeService#pageQery(com.jl.platform.common
	 * .PageQuery)
	 */
	@Override
	public Result<Pagination<Charge>> pageQery(PageQuery pageQuery) {
		return chargeMongoDBStore.pageQuery(pageQuery);
	}

	/*
	 * (non-Javadoc)
	 * @see com.jl.platform.service.ChargeService#delete(java.lang.String)
	 */
	@Override
	public Result delete(String id) {
		return chargeMongoDBStore.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.jl.platform.service.ChargeService#update(com.jl.platform.service.
	 * model.Charge)
	 */
	@Override
	public Result update(Charge charge) {
		return chargeMongoDBStore.update(charge);
	}

}
