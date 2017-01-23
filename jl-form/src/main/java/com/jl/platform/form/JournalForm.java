package com.jl.platform.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import java.util.List;

/**
 * Created by lishoubo on 16/6/19.
 */
public class JournalForm {
    private String id;
    /**
     * 监理工程师姓名
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "必须指定项目名字")
    private String staff;

    /**
     * 项目名称
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "必须指定项目名字")
    private String building;

    /**
     * 当前阶段
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "必须指定当前阶段")
    private String step;

    /**
     * 内容
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.RELAXED)
    @NotEmpty(message = "必须录入内容")
    private String content;

    private List<String> covers;

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

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
