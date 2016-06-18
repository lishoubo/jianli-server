package com.jl.platform.common;

/**
 * Created by lishoubo on 16/5/18.
 */
public enum StatusCode {
    SUCCESS(200, "SUCCESS", "处理成功"),
    SYSTEM_ERROR(500, "SYSTEM ERROR", "服务端出错"),
    SERVER_SAVE_FAIL(501, "SERVER SAVE FAIL", "服务端存储失败"),

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
