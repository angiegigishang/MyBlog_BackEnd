package com.lyf.common.enums;

public enum ErrorCode {

    SUC0000("SUC0000", "成功"),
    UKN0001("UKN0001", "未知错误"),

    ERR0001("ERR0001", "输入参数有误")

    ;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

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
}
