package com.lyf.common.controller;

import com.lyf.common.dto.RestHttpReply;
import com.lyf.common.enums.ErrorCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AppErrorController implements ErrorController {

    private static final String ErrPath = "/error";

    @RequestMapping(value = ErrPath, method = {RequestMethod.GET, RequestMethod.POST})
    public RestHttpReply error() {
        RestHttpReply reply = new RestHttpReply();
        reply.setHead(ErrorCode.UKN0001);
        return reply;
    }


    @Override
    public String getErrorPath() {
        return ErrPath;
    }
}
