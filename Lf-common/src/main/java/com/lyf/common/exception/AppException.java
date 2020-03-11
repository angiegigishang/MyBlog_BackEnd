package com.lyf.common.exception;

import com.lyf.common.enums.ErrorCode;

public class AppException extends RuntimeException {

    private String code;
    private String msg;

    public AppException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
