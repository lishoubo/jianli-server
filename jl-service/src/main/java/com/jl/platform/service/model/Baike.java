package com.jl.platform.service.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import com.jl.platform.common.Procedure;

/**
 * Created by lishoubo on 16/5/20. 监理百科
 */
public class Baike extends BaseModel {
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	@NotEmpty(message = "标题不能为空")
	private String title;

	private Procedure procedure;

	@SafeHtml(whitelistType = SafeHtml.WhiteListType.BASIC_WITH_IMAGES)
	@NotEmpty(message = "内容不能为空")
	private String content;

	@SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
	@NotEmpty(message = "作者不能为空")
	private String author;

	private Integer pv;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}
}
