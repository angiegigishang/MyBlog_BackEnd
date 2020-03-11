package com.lyf.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestHttpRequest {

    /**
     * head:
     *  xTrsSnd
     *  xRefNbr
     */
    @JsonProperty("HEAD")
    @NotNull
    private Map<String, String> head;

    @JsonProperty("BODY")
    @NotNull
    private Map<String, Object> body;

    public Map<String, String> getHead() {
        return head;
    }

    public void setHead(Map<String, String> head) {
        this.head = head;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
