/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.service.model;

import java.util.Date;

/**
 * @author zhanglu
 */
public class Experience {
	private Date startDate;

	private Date endDate;

	private String companyName;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
