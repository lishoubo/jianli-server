package com.jl.platform.service.model;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 监理工程师
 */
public class Staff extends BaseModel {
	@NotEmpty(message = "姓名不能为空")
	private String name;
	@Pattern(regexp = "\\d+", message = "等级必须是数字")
	/**等级*/
	private String grade;
	/** 资历 */
	private String qualification;
	/** 专业 */
	private String professional;
	/** 工作经验 */
	private List<Experience> experiences;

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

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

}
