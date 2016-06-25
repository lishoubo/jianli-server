package com.jl.platform.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lishoubo on 16/6/18.
 */
public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = 1295452213657638490L;
	private String _id;
	private String type;
	protected Date updateDate;
	protected Date createDate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

}
