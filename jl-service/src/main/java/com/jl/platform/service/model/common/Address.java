/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.service.model.common;

/**
 * @author zhanglu
 */
public class Address {
	/** 行政区 eg.余杭区 */
	private String district;

	/** 详细地址 */
	private String detailedAddr;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDetailedAddr() {
		return detailedAddr;
	}

	public void setDetailedAddr(String detailedAddr) {
		this.detailedAddr = detailedAddr;
	}

}
