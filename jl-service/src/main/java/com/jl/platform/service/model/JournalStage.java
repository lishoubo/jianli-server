/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.service.model;

import java.util.Date;

import com.jl.platform.common.Procedure;

/**
 * @author zhanglu
 */
public class JournalStage extends BaseModel {
	/** 发布时间 */
	private Date publishTime;

	/** 所属阶段 */
	private Procedure procedure;

	/** 内容 */
	private String content;

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
