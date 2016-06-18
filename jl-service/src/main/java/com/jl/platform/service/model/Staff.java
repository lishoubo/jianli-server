package com.jl.platform.service.model;


import org.hibernate.validator.constraints.NotEmpty;


public class Staff extends BaseModel {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "等级必须是数字")
    private String grade;
    private String qualification;
    private String professional;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

}
