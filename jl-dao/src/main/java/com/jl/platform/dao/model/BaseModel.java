package com.jl.platform.dao.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

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

	public void setUpdateDate(Date updateDate) {
		this.updateDate = String.valueOf(updateDate.getTime());
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = String.valueOf(createDate.getTime());
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
