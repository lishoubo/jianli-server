package com.my.home.common;

/**
 * Created by lishoubo on 16/5/18.
 */
public enum StatusCode {
    SUCCESS(0, "SUCCESS"),
    SYSTEM_ERROR(1, "SYSTEM ERROR");

    private final int code;
    private final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
