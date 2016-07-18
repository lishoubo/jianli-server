package com.jl.platform.common;

/**
 * Created by lishoubo on 16/5/18.
 */
public enum StatusCode {
	SUCCESS(200, "SUCCESS", "处理成功"),

	CLIENT_INVALID_REQUEST(300, "CLIENT INVALID REQUEST", "不合法的客户端请求"),

	RECORD_NOT_FOUND(404, "NOT FOUND RECORD", "没有找到相应的记录"),

	STAFF_NOT_FOUND(404, "NOT FOUND STAFF", "没有找到工程师"),

	BUILDING_NOT_FOUND(404, "NOT FOUND BUILDING", "没有找到相应的工程"),

	SYSTEM_ERROR(500, "SYSTEM ERROR", "服务端出错"),

	JOURNAL_NOT_FOUND(404, "NOT FOUND JOURNAL", "没有找到相应的日记"),

	//
	;
	private int code;
	private String message;
	private String description;

	StatusCode(int code, String message, String viewMessage) {
		this.code = code;
		this.message = message;
		this.description = viewMessage;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
