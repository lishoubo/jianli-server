/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.service.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zhanglu
 */
public class UpdateJournalForm {
	/** 日志id */
	@NotEmpty(message = "必须制定日记ID")
	private String id;

	/**
	 * 监理工程师姓名
	 */
	@NotEmpty(message = "必须指定监理工程师名字")
	private String staff;

	/**
	 * 项目名称
	 */
	@NotEmpty(message = "必须指定项目名字")
	private String building;

	/**
	 * 当前阶段
	 */
	@NotEmpty(message = "必须指定当前阶段")
	private String procedure;

	/**
	 * 内容
	 */
	@NotEmpty(message = "必须录入内容")
	private String content;

	private String cover;

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}
