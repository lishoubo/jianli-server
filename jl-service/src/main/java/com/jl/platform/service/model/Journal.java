package com.jl.platform.service.model;

import com.jl.platform.common.Procedure;

/**
 * Created by lishoubo on 16/6/19. 监理日志
 */
public class Journal extends BaseModel {
	private Building building;
	private Staff staff;
	private Procedure procedure;
	private String content;
	private String cover;

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}
