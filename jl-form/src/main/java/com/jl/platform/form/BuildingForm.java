package com.jl.platform.form;

import com.jl.platform.common.Address;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

/**
 * Created by lishoubo on 16/6/19. 项目工程
 */
public class BuildingForm {
    /**
     * 名称
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "必须指定项目名字")
    private String name;
    /**
     * 面积
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "必须指定面积")
    private String area;
    /**
     * 描述,户型
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "必须指定户型")
    private String description;

    /**
     * 位置
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "必须指定位置")
    private Address address;

    /**
     * 监理阶段
     */
    private String jlStep;

    /**
     * 监理类型
     */
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "必须设置监理类型")
    private String jlType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJlStep() {
        return jlStep;
    }

    public void setJlStep(String jlStep) {
        this.jlStep = jlStep;
    }

    public String getJlType() {
        return jlType;
    }

    public void setJlType(String jlType) {
        this.jlType = jlType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
