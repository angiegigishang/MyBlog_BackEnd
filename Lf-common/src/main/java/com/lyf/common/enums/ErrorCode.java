package com.lyf.common.enums;

public enum ErrorCode {

    SUC0000("SUC0000", "成功"),
    UKN0001("UKN0001", "未知错误"),

    ERR0001("ERR0001", "输入参数有误"),
    ERR0002("ERR0002", "新密码和旧密码不能相等"),
    ERR0003("ERR0003", "用户不存在"),
    ERR0004("ERR0004", "密码错误"),
    ERR0005("ERR0005", "用户未登录"),
    ERR0006("ERR0006", "登录凭证失效"),
    ERR0007("ERR0007", "用户非法操作"),

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
