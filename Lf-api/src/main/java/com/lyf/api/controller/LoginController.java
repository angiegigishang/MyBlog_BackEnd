package com.lyf.api.controller;

import com.lyf.api.dto.UsrLgnInn;
import com.lyf.common.dto.RestHttpReply;
import com.lyf.common.dto.RestHttpRequest;
import com.lyf.common.entity.LfyUsrDo;
import com.lyf.common.entity.LfyUsrLgn;
import com.lyf.common.enums.ErrorCode;
import com.lyf.common.exception.AppException;
import com.lyf.common.service.LoginService;
import com.lyf.common.utils.ThreadUtil;
import com.lyf.common.utils.ValidUtil;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Data
    class Token {
        private String token;
    }

    @PostMapping("/login")
    public RestHttpReply login(@Valid @RequestBody RestHttpRequest request) {
        RestHttpReply reply = new RestHttpReply();

        try {

            UsrLgnInn uin = new UsrLgnInn();
            BeanUtils.populate(uin, request.getBody());
            ValidUtil.validate(uin);

            LfyUsrLgn u = new LfyUsrLgn();
            u.setLfyUsrNbr(uin.getLfyUsrNbr());

            String token = loginService.login(u, uin.getLfyUsrPwd());

            Token t = new Token();
            t.setToken(token);

            reply.setBody(t);

        } catch (AppException e) {
            reply.setHead(e);
        } catch (Exception e) {
            reply.setHead(ErrorCode.UKN0001);
        }

        return reply;
    }

    @PostMapping("logout")
    public RestHttpReply logout(@Valid @RequestBody RestHttpRequest request) {
        RestHttpReply reply = new RestHttpReply();

        try {
            UsrLgnInn uin = new UsrLgnInn();
            BeanUtils.populate(uin, request.getBody());
            ValidUtil.validate(uin);

            LfyUsrDo user = (LfyUsrDo) ThreadUtil.get();
            if(!user.getLfyUsrNbr().equals(uin.getLfyUsrNbr())) {
                throw new AppException(ErrorCode.ERR0007);
            }

            loginService.logout(uin.getLfyUsrNbr());

        } catch (AppException e) {
            reply.setHead(e);
        } catch (Exception e) {
            reply.setHead(ErrorCode.UKN0001);
        }

        return reply;
    }


}
