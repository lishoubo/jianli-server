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
	private String location;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
