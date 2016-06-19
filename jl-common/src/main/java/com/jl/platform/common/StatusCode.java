package com.jl.platform.common;

/**
 * Created by lishoubo on 16/5/18.
 */
public enum StatusCode {
    SUCCESS(200, "SUCCESS", "处理成功"),
    CLIENT_INVALID_REQUEST(300, "CLIENT INVALID REQUEST", "不合法的客户端请求"),
    DATA_INVALID_SAME_NAME_STAFF(400, "STAFF NAME DUPLICATED", "工程师重名"),
    NOT_FOUND_STAFF(401, "NOT FOUND STAFF", "没有找到工程师"),
    NOT_FOUND_BUILDING(402, "NOT FOUND BUILDING", "没有找到项目"),
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
