package com.my.home.common;

/**
 * Created by lishoubo on 16/5/18.
 */
public class Result<T> {
	private boolean success;
	private int code;
	private String message;
	private T data;

	public static <T> Result result(StatusCode statusCode) {
		Result<T> result = new Result<>();
		result.setCode(statusCode.getCode());
		result.setMessage(statusCode.getMessage());
		return result;
	}

	public static <T> Result result(T data) {
		Result<T> result = new Result<>();
		result.setCode(0);
		result.setData(data);
		return result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
