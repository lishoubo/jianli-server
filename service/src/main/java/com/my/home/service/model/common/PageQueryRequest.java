/**
 * guanyuhuhu 2016年6月18日
 */
package com.my.home.service.model.common;

import com.my.home.common.ToString;

/**
 * @author zhanglu
 */
public class PageQueryRequest extends ToString {
	private int pageSize;

	private int pageNo;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
