package com.jl.platform.dao.model;

import java.util.List;

/**
 * Created by lishoubo on 16/6/19. 监理日志
 */
public class Journal extends BaseModel {
    private Building building;
    private Staff staff;
    private String content;
    private List<String> covers;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getCovers() {
        return covers;
    }

    public void setCovers(List<String> covers) {
        this.covers = covers;
    }
}
