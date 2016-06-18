package com.jl.platform.service.model.common;

import com.jl.platform.common.Result;

public class PageResult<T> extends Result<T> {
	/** default versionId */
	private static final long serialVersionUID = 5967551753988018107L;

	private int page;

	private int pageSize;

	private int pageTotal;

	public PageResult(T data) {
		super(data);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

}
