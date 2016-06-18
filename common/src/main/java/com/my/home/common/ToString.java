/**
 * guanyuhuhu 2016年6月18日
 */
package com.my.home.common;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author zhanglu
 */
public class ToString {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
