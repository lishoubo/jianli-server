package com.jl.platform.service.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

/**
 * 监理工程师
 */
public class Staff extends BaseModel {
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	@NotEmpty(message = "姓名不能为空")
	private String name;

	/** 资历 */
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	private int qualification;

	/** 监理头像URL */
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.BASIC)
	private String photo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQualification() {
		return qualification > 0 ? qualification : 1;
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
