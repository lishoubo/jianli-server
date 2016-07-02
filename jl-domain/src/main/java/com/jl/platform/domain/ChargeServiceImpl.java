/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.domain;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
