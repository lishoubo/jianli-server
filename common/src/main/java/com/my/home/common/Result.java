package com.my.home.common;

import java.io.Serializable;

/**
 * Created by lishoubo on 16/5/18.
 */
public class Result<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean success;
	private String code;
	private String message;
	private T data;

	public static <T> Result<T> result(StatusCode statusCode) {
		Result<T> result = new Result<>();
		result.setCode(statusCode.getCode());
		result.setMessage(statusCode.getViewMesage());
		return result;
	}

	public static <T> Result<T> result(T data) {
		Result<T> result = result(StatusCode.SUCCESS);
		result.setData(data);
		return result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

}
