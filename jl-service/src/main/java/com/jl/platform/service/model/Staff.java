package com.jl.platform.service.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 监理工程师
 */
public class Staff extends BaseModel {
	@NotEmpty(message = "姓名不能为空")
	private String name;
	@Pattern(regexp = "\\d+", message = "等级必须是数字")
	/** 资历 */
	private int qualification;
	/** 监理头像URL */
	private String photo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQualification() {
		return qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
