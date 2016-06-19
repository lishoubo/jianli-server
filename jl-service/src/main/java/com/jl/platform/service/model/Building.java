package com.jl.platform.service.model;

import com.jl.platform.common.Procedure;

/**
 * Created by lishoubo on 16/6/19. 项目工程
 */
public class Building extends BaseModel {
	private String staffName;
	private String name; // 项目名称
	private String distinct; // 区
	private String address;
	private Procedure procedure;// 当前阶段

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistinct() {
		return distinct;
	}

	public void setDistinct(String distinct) {
		this.distinct = distinct;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

}
