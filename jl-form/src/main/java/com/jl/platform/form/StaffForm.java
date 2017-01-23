package com.jl.platform.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

/**
 * 监理工程师
 */
public class StaffForm {
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    @NotEmpty(message = "监理工程师名字")
    private String name;
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    private String title;
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
