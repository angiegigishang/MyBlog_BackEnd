package com.lyf.api.controller;

import com.lyf.common.dto.RestHttpReply;
import com.lyf.common.dto.RestHttpRequest;
import com.lyf.common.entity.LfyUsrDo;
import com.lyf.common.enums.ErrorCode;
import com.lyf.common.exception.AppException;
import com.lyf.common.service.UserService;
import com.lyf.common.utils.DateTimeUtil;
import com.lyf.common.utils.Md5Util;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public RestHttpReply getUserList() {
        RestHttpReply reply = new RestHttpReply();

        try {
            reply.setBody(userService.getList());
        } catch (AppException e) {
            reply.setHead(e);
        } catch (Exception e) {
            reply.setHead(ErrorCode.UKN0001);
        }

        return reply;
    }


    @PostMapping("/adduser")
    public RestHttpReply addUser(@RequestBody @Valid RestHttpRequest request) {
        RestHttpReply reply = new RestHttpReply();

        try {

            LfyUsrDo user = new LfyUsrDo();
            BeanUtils.populate(user, request.getBody());
            validate(user);

            user.setLfyUsrPwd(Md5Util.encode(user.getLfyUsrPwd()));
            user.setLfyMntDat(DateTimeUtil.currentDate());
            user.setLfyMntTim(DateTimeUtil.currentTime());

            userService.add(user);

        } catch (AppException e) {
            reply.setHead(e);
        } catch (Exception e) {
            reply.setHead(ErrorCode.UKN0001);
        }

        return reply;
    }



    private void validate(@Valid LfyUsrDo user) {
        Set<ConstraintViolation<@Valid LfyUsrDo>> validateSet = Validation.buildDefaultValidatorFactory()
                .getValidator()
                .validate(user, new Class[0]);
        if (!CollectionUtils.isEmpty(validateSet)) {
            throw new AppException(ErrorCode.ERR0001);
        }
    }


}
