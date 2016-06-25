package com.jl.platform.service.model;

/**
 * Created by lishoubo on 16/6/19. 监理日志
 */
public class Journal extends BaseModel {
	private Building building;
	private Staff staff;
	private JournalStage stage;

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

	public JournalStage getStage() {
		return stage;
	}

	public void setStage(JournalStage stage) {
		this.stage = stage;
	}

}
