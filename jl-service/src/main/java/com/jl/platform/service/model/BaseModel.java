package com.jl.platform.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lishoubo on 16/6/18.
 */
public abstract class BaseModel implements Serializable {
    protected Date updateTime;
    protected Date createTime;

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
}
