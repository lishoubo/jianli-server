/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.common;

/**
 * @author zhanglu 装修类型枚举类
 */
public enum FitmentType {

	LUXURY("豪华装修"),

	FINE("精装修"),

	SIMPLE("简装修");

	private String desc;

	FitmentType(String desc) {
		this.desc = desc;
	}

}
