package com.lyf.common.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lyf.common.enums.ErrorCode;
import com.lyf.common.exception.AppException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestHttpReply {

    /**
     * head:
     *  xRtnCod
     *  xErrMsg
     */
    @JsonProperty("HEAD")
    private Map<String, String> head;

    @JsonProperty("BODY")
    private Object body;


    public RestHttpReply() {
        this.head = new HashMap<>();
        this.head.put("xRtnCod", ErrorCode.SUC0000.getCode());
        this.head.put("xErrMsg", ErrorCode.SUC0000.getMessage());
    }

    public void setHead(ErrorCode errorCode) {
        this.head.put("xRtnCod", errorCode.getCode());
        this.head.put("xErrMsg", errorCode.getMessage());
    }

    public void setHead(AppException e) {
        this.head.put("xRtnCod", e.getCode());
        this.head.put("xErrMsg", e.getMsg());
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Map<String, String> getHead() {
        return head;
    }

    public void setHead(Map<String, String> head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

}
