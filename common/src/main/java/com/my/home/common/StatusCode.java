package com.my.home.common;

/**
 * Created by lishoubo on 16/5/18.
 */
public enum StatusCode {
	SUCCESS("0", "SUCCESS", "处理成功"), SYSTEM_ERROR("1", "SYSTEM ERROR", "网路异常"), NULL_PARAM(
			"00100", "参数为空", "入参不能为空");

	private String code;
	private String message;
	private String viewMesage;

	StatusCode(String code, String message, String viewMessage) {
		this.code = code;
		this.message = message;
		this.viewMesage = viewMessage;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getViewMesage() {
		return viewMesage;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setViewMesage(String viewMesage) {
		this.viewMesage = viewMesage;
	}

}
