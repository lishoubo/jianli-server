package com.jl.platform.common;

import java.io.Serializable;

/**
 * Created by lishoubo on 16/5/18.
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;
    private String code;
    private String message;
    private T data;

    public Result() {
        super();
    }

    public Result(StatusCode statusCode) {
        Result<T> result = new Result<T>();
        result.setCode(statusCode.getCode());
        result.setMessage(statusCode.getDescription());
        if (statusCode == StatusCode.SUCCESS) {
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
    }

    public Result(T data) {
        Result<T> result = new Result<T>(StatusCode.SUCCESS);
        result.setData(data);
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
