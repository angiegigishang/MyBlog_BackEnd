package com.lyf.common.service;

import com.lyf.common.entity.LfyUsrDo;
import com.lyf.common.entity.LfyUsrLgn;
import com.lyf.common.enums.ErrorCode;
import com.lyf.common.exception.AppException;
import com.lyf.common.mapper.LoginMapper;
import com.lyf.common.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private UserService userService;

    public String login(LfyUsrLgn lfyUsrLgn, String pwd) {

        LfyUsrDo usr = userService.getUser(lfyUsrLgn.getLfyUsrNbr());
        if(usr == null) {
            throw new AppException(ErrorCode.ERR0003);
        } else if(usr.getLfyUsrPwd() != null && !usr.getLfyUsrPwd().equals(Md5Util.encode(pwd))) {
            throw new AppException(ErrorCode.ERR0004);
        }


        LfyUsrLgn loginTic = loginMapper.select(lfyUsrLgn.getLfyUsrNbr());

        if(loginTic == null) {
            String token = UUID.randomUUID().toString();
            LocalDateTime now = LocalDateTime.now();
            lfyUsrLgn.setLfyUsrTok(token);
            lfyUsrLgn.setLfyLgnTim(now);
            loginMapper.insert(lfyUsrLgn);

            return token;
        } else {
            return loginTic.getLfyUsrTok();
        }

    }


    public void logout(String id) {
        loginMapper.logout(id);
    }

}
