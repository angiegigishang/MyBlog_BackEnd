package com.lyf.api.controller;

import com.lyf.common.dto.RestHttpReply;
import com.lyf.common.dto.RestHttpRequest;
import com.lyf.common.enums.ErrorCode;
import com.lyf.common.exception.AppException;
import com.lyf.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public RestHttpReply getUserList(@RequestBody @Valid RestHttpRequest request) {
        RestHttpReply reply = new RestHttpReply();

        System.out.println(request.getHead());
        System.out.println(request.getBody());

        try {
            reply.setBody(userService.getList());
        } catch (AppException e) {
            reply.setHead(e);
        } catch (Exception e) {
            reply.setHead(ErrorCode.UKN0001);
        }

        return reply;
    }

}
