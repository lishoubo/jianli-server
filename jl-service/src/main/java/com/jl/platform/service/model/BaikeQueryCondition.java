/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.service.model;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Procedure;

/**
 * @author zhanglu
 */
public class BaikeQueryCondition extends PageQuery {
	private String sortConditions;

	private Procedure procedure;

	public String getSortConditions() {
		return sortConditions;
	}

	public void setSortConditions(String sortConditions) {
		this.sortConditions = sortConditions;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

}
