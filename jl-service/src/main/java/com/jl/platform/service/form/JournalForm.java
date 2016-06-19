package com.jl.platform.service.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by lishoubo on 16/6/19.
 */
public class JournalForm {
    /**
     * 监理工程师姓名
     */
    @NotEmpty(message = "必须指定监理工程师名字")
    private String staffName;

    /**
     * 项目名称
     */
    @NotEmpty(message = "必须指定项目名字")
    private String buildingName;

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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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
}
