package com.lyf.common.service;

import com.lyf.common.entity.LfyUsrDo;
import com.lyf.common.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<LfyUsrDo> getList() {
        return userMapper.getList();
    }

    public void add(LfyUsrDo user) {
        userMapper.addUser(user);
    }

    public void uptUser(LfyUsrDo usr) {
        userMapper.uptUser(usr);
    }

    public LfyUsrDo getUser(String id) {
        return userMapper.getUser(id);
    }


}
