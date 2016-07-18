package com.jl.platform.service.model;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import com.jl.platform.common.Procedure;
import com.jl.platform.service.model.common.Address;

/**
 * Created by lishoubo on 16/6/19. 项目工程
 */
public class Building extends BaseModel {
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	private String staff;

	/** 项目名称 */
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	@NotEmpty(message = "请录入项目名称")
	private String name;

	/** 当前阶段 */
	private Procedure procedure;

	private @Valid
	Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
