package com.jl.platform.dao.model;

/**
 * 监理工程师
 */
public class Staff extends BaseModel {
    private String name;
    private String title;
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
