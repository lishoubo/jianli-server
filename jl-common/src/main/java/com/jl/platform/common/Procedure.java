package com.jl.platform.common;

/**
 * Created by lishoubo on 16/6/18.
 */
public enum Procedure {
	PREPARE("前期准备"),

	DESIGN("方案设计"),

	PURCHASE("建材采购"),

	HARD_CONSTRUCT("硬装施工"),

	SOFT_DECORATE("软装配饰"),

	ACCEPTANCE("工程验收"), ;

	private String desc;

	Procedure(String desc) {
		this.desc = desc;
	}
}
