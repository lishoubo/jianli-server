package com.jl.platform.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lishoubo on 16/6/18.
 */
public abstract class BaseModel implements Serializable {
	private String _id;
	private String type;
	protected Date updateTime;
	protected Date createTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

}
