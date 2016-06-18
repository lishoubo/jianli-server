package com.jl.platform.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lishoubo on 16/5/18.
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private T data;

    public static <T> Result create(T data) {
        Result<T> tResult = new Result<>();
        tResult.setCode(StatusCode.SUCCESS.getCode());
        tResult.setData(data);
        return tResult;
    }

    public static <T> Result create(StatusCode statusCode) {
        Result<T> result = new Result<T>();
        result.setCode(statusCode.getCode());
        result.setMessage(statusCode.getDescription());
        return result;
    }

    public static <T> Result create(int code, String message) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<Pagination<T>> pagination(List<T> items, PageQuery pageQuery, int totalPage) {
        Pagination<T> pagination = new Pagination<T>();
        pagination.setItems(items);
        pagination.setPage(pageQuery.getPage());
        pagination.setPageSize(pageQuery.getPageSize());
        pagination.setPageTotal(totalPage);
        return Result.create(pagination);
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

    public boolean isSuccess() {
        return code == StatusCode.SUCCESS.getCode();
    }
}
