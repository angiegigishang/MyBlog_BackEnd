package com.lyf.api.controller;

import com.lyf.api.dto.UsrPwdChg;
import com.lyf.common.dto.RestHttpReply;
import com.lyf.common.dto.RestHttpRequest;
import com.lyf.common.entity.LfyUsrDo;
import com.lyf.common.enums.ErrorCode;
import com.lyf.common.exception.AppException;
import com.lyf.common.service.UserService;
import com.lyf.common.utils.DateTimeUtil;
import com.lyf.common.utils.Md5Util;
import com.lyf.common.utils.ValidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
            ValidUtil.validate(user);

            user.setLfyUsrPwd(Md5Util.encode(user.getLfyUsrPwd()));
            user.setLfyMntDat(DateTimeUtil.getCurrent().getCurDat());
            user.setLfyMntTim(DateTimeUtil.getCurrent().getCurTim());

            userService.add(user);

        } catch (AppException e) {
            reply.setHead(e);
        } catch (Exception e) {
            reply.setHead(ErrorCode.UKN0001);
        }

        return reply;
    }


    @PostMapping("/changepwd")
    public RestHttpReply changePwd(@RequestBody @Valid RestHttpRequest request) {
        RestHttpReply reply = new RestHttpReply();

        try {
            UsrPwdChg usr = new UsrPwdChg();
            BeanUtils.populate(usr, request.getBody());
            ValidUtil.validate(usr);

            if(usr.getLfyNewPwd().equals(usr.getLfyUsrPwd())) {
                throw new AppException(ErrorCode.ERR0002);
            }

            LfyUsrDo usrDo = new LfyUsrDo();
            BeanUtils.copyProperties(usrDo, usr);
            usrDo.setLfyUsrPwd(Md5Util.encode(usr.getLfyNewPwd()));

            userService.uptUser(usrDo);

        } catch (AppException e) {
            reply.setHead(e);
        } catch (Exception e) {
            reply.setHead(ErrorCode.UKN0001);
        }

        return reply;
    }



}
