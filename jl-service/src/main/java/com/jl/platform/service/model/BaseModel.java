package com.jl.platform.service.model;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by lishoubo on 16/6/18.
 */
public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = 1295452213657638490L;
	private String _id;
	protected String updateDate;
	protected String createDate;

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@JSONField(name = "_id")
	public String getId() {
		return _id;
	}

	@JSONField(name = "_id")
	public void setId(String id) {
		this._id = id;
	}
}
